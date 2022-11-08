package uz.nurlibaydev.ecommerce.domain.repository.detail

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.detail.ProductDetailData
import uz.nurlibaydev.ecommerce.utils.UiState

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 17:28
 */

interface ProductDetailRepository {
    fun getProductDetail(): Flow<UiState<ProductDetailData>>
}