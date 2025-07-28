package com.example.nectar.domain.repository

import com.example.nectar.data.model.CartItem
import com.example.nectar.domain.model.cart
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getAllCartItems(): Flow<List<cart>>
    fun getCartItem(id:Int): Flow<cart>
    suspend fun insertCartItem(cartItem: cart)
    suspend fun deleteCartItem(cartItem: cart)
    suspend fun updateCartItem(cartItem: cart)
}