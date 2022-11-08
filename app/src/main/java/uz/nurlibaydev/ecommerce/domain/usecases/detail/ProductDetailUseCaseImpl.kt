package uz.nurlibaydev.ecommerce.domain.usecases.detail

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.detail.ProductDetailData
import uz.nurlibaydev.ecommerce.domain.repository.detail.ProductDetailRepository
import uz.nurlibaydev.ecommerce.utils.UiState
import javax.inject.Inject

class ProductDetailUseCaseImpl @Inject constructor(
    private val productDetailRepository: ProductDetailRepository
): ProductDetailUseCase {
    override fun getProductDetail(): Flow<UiState<ProductDetailData>> {
        return productDetailRepository.getProductDetail()
    }
}