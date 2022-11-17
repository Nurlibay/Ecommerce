package uz.nurlibaydev.ecommerce.presentation.main.explorer

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.data.models.responce.product.BestSeller
import uz.nurlibaydev.ecommerce.databinding.ItemBestSellerBinding

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 22:47
 */

class BestSellerAdapter: ListAdapter<BestSeller, BestSellerAdapter.BestSellerViewHolder>(BestSellerItemCallback) {

    inner class BestSellerViewHolder(private val binding: ItemBestSellerBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun onBind(){
            val item = getItem(absoluteAdapterPosition)
            binding.apply {
                tvPriceWithoutDiscount.text = "$${item.price_without_discount}"
                tvTitle.text = item.title
                tvDiscountPrice.text = item.discount_price.toString()
                Glide
                    .with(root.context)
                    .load(item.picture)
                    .into(ivProduct)

                if(getItem(absoluteAdapterPosition).is_favorites){
                    ivFavourite.setImageResource(R.drawable.ic_favorite)
                } else {
                    ivFavourite.setImageResource(R.drawable.ic_favorite_border)
                }

                root.setOnClickListener {

                }
            }
        }
    }

    private var itemClick: (BestSeller)-> Unit = {}
    fun setOnBestSellerItemClickSelectListener(block: (BestSeller) -> Unit){
        itemClick = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        return BestSellerViewHolder(ItemBestSellerBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_best_seller, parent, false)))
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.onBind()
    }
}

object BestSellerItemCallback : DiffUtil.ItemCallback<BestSeller>() {

    override fun areItemsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BestSeller, newItem: BestSeller): Boolean {
        return oldItem.id == newItem.id && oldItem.picture == newItem.picture && oldItem.discount_price == newItem.discount_price
                && oldItem.price_without_discount == newItem.price_without_discount && oldItem.title == newItem.title
    }
}