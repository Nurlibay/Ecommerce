package uz.nurlibaydev.ecommerce.presentation.main.explorer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.data.models.CategoryData
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStore
import uz.nurlibaydev.ecommerce.databinding.ItemHotSalesBinding

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 19:41
 */

class HotSalesAdapter: ListAdapter<HomeStore, HotSalesAdapter.HotSalesViewHolder>(HotSalesItemCallback) {

    inner class HotSalesViewHolder(private val binding: ItemHotSalesBinding): ViewHolder(binding.root){
        fun onBind(){
            val item = getItem(absoluteAdapterPosition)
            binding.apply {
                title.text = item.title
                description.text = item.subtitle
                Glide
                    .with(binding.root.context)
                    .load(item.picture)
                    .centerInside()
                    .into(ivBackground)
            }
        }
    }

    private var itemClick: (HomeStore)-> Unit = {}
    fun setOnItemCategorySelectListener(block: (HomeStore) -> Unit){
        itemClick = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        return HotSalesViewHolder(ItemHotSalesBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_hot_sales, parent, false)))
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.onBind()
    }
}

object HotSalesItemCallback : DiffUtil.ItemCallback<HomeStore>() {

    override fun areItemsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HomeStore, newItem: HomeStore): Boolean {
        return oldItem.id == newItem.id && oldItem.is_new == newItem.is_new && oldItem.picture == newItem.picture
                && oldItem.subtitle == newItem.subtitle
    }
}