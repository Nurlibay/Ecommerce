package uz.nurlibaydev.ecommerce.domain.usecases.detail

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.detail.ProductDetailData
import uz.nurlibaydev.ecommerce.utils.UiState

interface ProductDetailUseCase {
    fun getProductDetail(): Flow<UiState<ProductDetailData>>
}