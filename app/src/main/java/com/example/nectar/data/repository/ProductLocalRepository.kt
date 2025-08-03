package com.example.nectar.data.repository

import com.example.nectar.data.local.Dao.productDao
import com.example.nectar.data.model.toDomain
import com.example.nectar.domain.model.product
import com.example.nectar.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductLocalRepository @Inject constructor(private val productDao: productDao): ProductRepository {
    override fun getAllProducts(): Flow<List<product>> {
       return productDao.getAllProducts().map{ list ->
           list.map { it.toDomain() }
       }
    }

    override fun getCategory(category: String): Flow<List<product>> {
        return productDao.getCategoryProducts(category).map{ list ->
            list.map { it.toDomain() }
        }
    }

    override fun search(name: String): Flow<List<product>> {
        return productDao.SearchProductbyName(name).map{ list ->
            list.map { it.toDomain() }
        }
    }

    override fun getProduct(id: Int): Flow<product> {
        return productDao.GetSpecificProduct(id).map{ it.toDomain() }
        }
}