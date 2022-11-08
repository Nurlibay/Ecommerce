package uz.nurlibaydev.ecommerce.presentation.main.explorer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData
import uz.nurlibaydev.ecommerce.domain.usecases.product.ProductUseCase
import uz.nurlibaydev.ecommerce.utils.UiState
import uz.nurlibaydev.ecommerce.utils.hasConnection
import javax.inject.Inject

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 17:39
 */

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
): ViewModel() {

    private val _products = MutableStateFlow<UiState<HomeStoreData>>(UiState.Empty)
    val products: StateFlow<UiState<HomeStoreData>> = _products

    fun getProducts() {
        if (!hasConnection()) {
            _products.value = UiState.NetworkError("No Internet Connection!")
            return
        }
        viewModelScope.launch {
            _products.value = UiState.Loading
            productUseCase.getProducts().collect {
                when (it) {
                    is UiState.Success -> {
                        val result = it.data
                        _products.value = UiState.Success(result)
                    }
                    is UiState.Error -> {
                        _products.value = UiState.Error(it.msg)
                    }
                    else -> {}
                }
            }
        }
    }
}