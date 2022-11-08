package uz.nurlibaydev.ecommerce.domain.repository.detail

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.nurlibaydev.ecommerce.data.models.responce.detail.ProductDetailData
import uz.nurlibaydev.ecommerce.data.source.remote.ProductDetailApi
import uz.nurlibaydev.ecommerce.utils.UiState
import javax.inject.Inject

class ProductDetailRepositoryImpl @Inject constructor(
    private val productDetailApi: ProductDetailApi
) : ProductDetailRepository {

    override fun getProductDetail(): Flow<UiState<ProductDetailData>> = flow {
        val response = productDetailApi.getProductDetails()
        if(response.isSuccessful){
            emit(UiState.Loading)
            emit(UiState.Success(response.body()!!))
        } else {
            emit(UiState.Error(response.errorBody()?.string().toString()))
        }
    }.catch {
        emit(UiState.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}