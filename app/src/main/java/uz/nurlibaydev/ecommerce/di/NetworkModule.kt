package uz.nurlibaydev.ecommerce.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.nurlibaydev.ecommerce.data.source.remote.ProductApi
import uz.nurlibaydev.ecommerce.data.source.remote.ProductDetailApi
import uz.nurlibaydev.ecommerce.utils.Constants.BASE_URL
import uz.nurlibaydev.ecommerce.utils.interceptor.CacheInterceptor
import javax.inject.Singleton

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 17:05
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun getGsonObject(): Gson = Gson()

    @[Provides Singleton]
    fun provideHttpLoggingInterceptor():HttpLoggingInterceptor{
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @[Provides Singleton]
    fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
        return ChuckerInterceptor.Builder(context).build()
    }

    @[Provides Singleton]
    fun getOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .addNetworkInterceptor(CacheInterceptor())
            .build()
    }

    @[Provides Singleton]
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client)
            .build()
    }

    @[Provides Singleton]
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @[Provides Singleton]
    fun provideProductDetailApi(retrofit: Retrofit): ProductDetailApi {
        return retrofit.create(ProductDetailApi::class.java)
    }
}