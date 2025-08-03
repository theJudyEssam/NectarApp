package com.example.nectar.domain.usecases

import com.example.nectar.data.repository.ProductLocalRepository
import com.example.nectar.domain.model.product
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetProductsUseCase @Inject constructor(
    private val repository: ProductLocalRepository
){
    operator fun invoke(): Flow<List<product>> = repository.getAllProducts()
}

class GetCategoryProductsUseCase @Inject constructor(
    private val repository: ProductLocalRepository
){
    operator fun invoke(category: String): Flow<List<product>> = repository.getCategory(category)
}

class SearchProductUseCase @Inject constructor(
    private val repository: ProductLocalRepository
){
    operator fun invoke(name: String): Flow<List<product>> = repository.search(name)
}

class GetSpecificProductUseCase  @Inject constructor(
    private val repository: ProductLocalRepository
){
    operator fun invoke(id: Int): Flow<product> = repository.getProduct(id)
}