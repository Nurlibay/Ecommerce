package uz.nurlibaydev.ecommerce.domain.repository.product

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData
import uz.nurlibaydev.ecommerce.data.source.remote.ProductApi
import uz.nurlibaydev.ecommerce.utils.UiState
import javax.inject.Inject


class ProductRepositoryImpl @Inject constructor(
    private val productApi: ProductApi
) : ProductRepository {

    override fun getProducts(): Flow<UiState<HomeStoreData>> = flow {
        val response = productApi.getProducts()
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