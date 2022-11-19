package uz.nurlibaydev.ecommerce.presentation.main.explorer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.data.models.CategoryData
import uz.nurlibaydev.ecommerce.databinding.ItemCategoryBinding

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 19:41
 */

class CategoryAdapter: ListAdapter<CategoryData, CategoryAdapter.CategoryViewHolder>(CategoryItemCallback) {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding): ViewHolder(binding.root){
        fun onBind(){
            val item = getItem(absoluteAdapterPosition)
            binding.apply {
                tvCategoryName.text = item.name
                Glide
                    .with(binding.root.context)
                    .load(item.icon)
                    .centerInside()
                    .into(ivCircle)

                if(getItem(absoluteAdapterPosition).selected){
                    ivCircle.setBackgroundColor(ContextCompat.getColor(root.context, R.color.color_yellow))
                } else {
                    ivCircle.setBackgroundColor(ContextCompat.getColor(root.context, R.color.white))
                }

                root.setOnClickListener {
                    val data = getItem(absoluteAdapterPosition)
                    itemClick.invoke(data.copy(selected = true))
                }
            }
        }
    }

    private var itemClick: (CategoryData)-> Unit = {}
    fun setOnItemCategorySelectListener(block: (CategoryData) -> Unit){
        itemClick = block
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind()
    }
}

object CategoryItemCallback : DiffUtil.ItemCallback<CategoryData>() {

    override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean {
        return oldItem == newItem
    }
}