package com.example.nectar.domain.repository

import com.example.nectar.domain.model.product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getAllProducts(): Flow<List<product>>
    fun getCategory(category:String): Flow<List<product>>
    fun search(name:String): Flow<List<product>>
    fun getProduct(id: Int): Flow<product>
}