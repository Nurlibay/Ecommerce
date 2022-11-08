package uz.nurlibaydev.ecommerce.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.nurlibaydev.ecommerce.data.models.responce.detail.ProductDetailData

interface ProductDetailApi {

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getProductDetails(): Response<ProductDetailData>

}