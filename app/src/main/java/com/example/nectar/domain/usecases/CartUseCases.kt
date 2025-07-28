package com.example.nectar.domain.usecases

import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.product
import com.example.nectar.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    operator fun invoke(): Flow<List<cart>> = repository.getAllCartItems()
}

class InsertCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(cart: cart) = repository.insertCartItem(cart)
}

class DeleteCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(cart:cart) = repository.deleteCartItem(cart)
}

class UpdateCartUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(cart:cart) = repository.updateCartItem(cart)
}


class ToggleUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(product: product) = repository.toggleCartItem(product)
}

class IncrementUseCase  @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(product: product) = repository.incrementCartItem(product)
}

class DecrementUseCase @Inject constructor(
    private val repository: CartRepository
){
    suspend operator fun invoke(product: product) = repository.decrementCartItem(product)
}