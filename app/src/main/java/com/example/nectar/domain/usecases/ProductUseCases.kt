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