package uz.nurlibaydev.ecommerce.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData
import uz.nurlibaydev.ecommerce.utils.UiState

interface ProductUseCase {
    fun getProducts(): Flow<UiState<HomeStoreData>>
}