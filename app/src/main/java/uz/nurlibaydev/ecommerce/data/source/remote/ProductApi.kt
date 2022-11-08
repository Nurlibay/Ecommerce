package uz.nurlibaydev.ecommerce.data.source.remote

import retrofit2.Response
import retrofit2.http.GET
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData

interface ProductApi {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): Response<HomeStoreData>

}