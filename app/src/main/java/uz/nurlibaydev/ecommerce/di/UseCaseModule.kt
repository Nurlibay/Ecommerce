package uz.nurlibaydev.ecommerce.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.nurlibaydev.ecommerce.domain.usecases.detail.ProductDetailUseCase
import uz.nurlibaydev.ecommerce.domain.usecases.detail.ProductDetailUseCaseImpl
import uz.nurlibaydev.ecommerce.domain.usecases.product.ProductUseCase
import uz.nurlibaydev.ecommerce.domain.usecases.product.ProductUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindProductUseCase(impl: ProductUseCaseImpl): ProductUseCase

    @Binds
    fun bindProductDetailUseCase(impl: ProductDetailUseCaseImpl): ProductDetailUseCase
}