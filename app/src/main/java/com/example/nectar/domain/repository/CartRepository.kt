package com.example.nectar.domain.repository

import com.example.nectar.data.model.CartItem
import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getAllCartItems(): Flow<List<cart>>
    fun observeCartItem(id:Int):Flow<cart?>
    suspend fun emptyCart()
    suspend fun getCartItem(id:Int): cart?
    suspend fun insertCartItem(cartItem: cart)
    suspend fun deleteCartItem(cartItem: cart)
    suspend fun updateCartItem(cartItem: cart)
    suspend fun toggleCartItem(product: product)
    suspend fun incrementCartItem(product: product)
    suspend fun decrementCartItem(product: product)
}