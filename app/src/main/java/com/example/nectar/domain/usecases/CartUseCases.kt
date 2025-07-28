package com.example.nectar.domain.usecases

import com.example.nectar.domain.model.cart
import com.example.nectar.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    operator fun invoke(): Flow<List<cart>> = repository.getAllCartItems()
}

class GetSpecificCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    operator fun invoke(id: Int): Flow<cart> = repository.getCartItem(id)
}