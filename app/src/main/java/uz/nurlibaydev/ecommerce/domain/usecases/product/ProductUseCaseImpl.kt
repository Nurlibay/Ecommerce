package uz.nurlibaydev.ecommerce.domain.usecases.product

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData
import uz.nurlibaydev.ecommerce.domain.repository.product.ProductRepository
import uz.nurlibaydev.ecommerce.utils.UiState
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
): ProductUseCase {
    override fun getProducts(): Flow<UiState<HomeStoreData>> {
        return productRepository.getProducts()
    }
}