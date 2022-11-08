package uz.nurlibaydev.ecommerce.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.nurlibaydev.ecommerce.domain.repository.detail.ProductDetailRepository
import uz.nurlibaydev.ecommerce.domain.repository.detail.ProductDetailRepositoryImpl
import uz.nurlibaydev.ecommerce.domain.repository.product.ProductRepository
import uz.nurlibaydev.ecommerce.domain.repository.product.ProductRepositoryImpl
import javax.inject.Singleton

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 17:25
 */

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @[Binds Singleton]
    fun bindProductDetailRepository(impl: ProductDetailRepositoryImpl): ProductDetailRepository
}