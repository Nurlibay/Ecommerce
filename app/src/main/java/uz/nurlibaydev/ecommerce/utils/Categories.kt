package uz.nurlibaydev.ecommerce.utils

import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.data.models.CategoryData

object Categories {

    val list = mutableListOf<CategoryData>()

    init {
        list.add(CategoryData(1, "Phones", R.drawable.img_phone, true))
        list.add(CategoryData(2, "Computer", R.drawable.computer, false))
        list.add(CategoryData(3, "Health", R.drawable.health, false))
        list.add(CategoryData(4, "Books", R.drawable.books, false))
        list.add(CategoryData(5, "Phones", R.drawable.img_phone, false))
        list.add(CategoryData(6, "Computer", R.drawable.computer, false))
        list.add(CategoryData(7, "Health", R.drawable.health, false))
        list.add(CategoryData(8, "Books", R.drawable.books, false))
    }
}