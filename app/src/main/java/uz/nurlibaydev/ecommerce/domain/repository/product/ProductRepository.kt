package uz.nurlibaydev.ecommerce.domain.repository.product

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.ecommerce.data.models.responce.product.HomeStoreData
import uz.nurlibaydev.ecommerce.utils.UiState

/**
 *  Created by Nurlibay Koshkinbaev on 08/11/2022 17:18
 */

interface ProductRepository {
    fun getProducts(): Flow<UiState<HomeStoreData>>
}