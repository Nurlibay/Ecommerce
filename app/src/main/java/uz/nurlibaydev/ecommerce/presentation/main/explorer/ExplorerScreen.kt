package uz.nurlibaydev.ecommerce.presentation.main.explorer

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.nurlibaydev.ecommerce.R
import uz.nurlibaydev.ecommerce.data.models.CategoryData
import uz.nurlibaydev.ecommerce.databinding.ScreenExplorerBinding
import uz.nurlibaydev.ecommerce.utils.Categories
import uz.nurlibaydev.ecommerce.utils.UiState
import uz.nurlibaydev.ecommerce.utils.extenions.showMessage

/**
 *  Created by Nurlibay Koshkinbaev on 07/11/2022 15:23
 */

@AndroidEntryPoint
class ExplorerScreen: Fragment(R.layout.screen_explorer) {

    private val binding: ScreenExplorerBinding by viewBinding()
    private val categoryAdapter by lazy(LazyThreadSafetyMode.NONE) { CategoryAdapter() }
    private val hotSalesAdapter by lazy(LazyThreadSafetyMode.NONE) { HotSalesAdapter() }
    private val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController() }
    private val viewModel: ProductViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterSetup()
        viewModel.getProducts()
        setupObserver()
    }

    private fun adapterSetup() {
        binding.apply {
            rvCategories.adapter = categoryAdapter
            rvHotSales.adapter = hotSalesAdapter
            categoryAdapter.submitList(Categories.list)
        }
        categoryAdapter.setOnItemCategorySelectListener {
            val list = mutableListOf<CategoryData>()
            /** to do */
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenResumed {
            viewModel.products.collect {
                when (it) {
                    is UiState.Loading -> {
                        loading(true)
                    }
                    is UiState.NetworkError -> {
                        loading(false)
                        showMessage(it.msg!!)
                    }
                    is UiState.Error -> {
                        loading(false)
                        showMessage(it.msg!!)
                    }
                    is UiState.Success -> {
                        loading(false)
                        hotSalesAdapter.submitList(it.data.home_store)
                    }
                    else -> {
                        loading(false)
                    }
                }
            }
        }
    }
    
    private fun loading(b: Boolean) {
        binding.progressBar.isVisible = b
    }
}