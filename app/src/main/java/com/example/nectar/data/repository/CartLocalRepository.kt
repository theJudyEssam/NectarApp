package com.example.nectar.data.repository

import com.example.nectar.data.local.cartDao
import com.example.nectar.data.model.CartItem
import com.example.nectar.data.model.toDomain
import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.toEntity
import com.example.nectar.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartLocalRepository
    (private val cartDao: cartDao): CartRepository {

    override fun getAllCartItems(): Flow<List<cart>> {
        return cartDao.getAllCartItems().map {
            list -> list.map{ it.toDomain()}
        }
    }

    override fun getCartItem(id: Int): Flow<cart> {
        return cartDao.getSpecificCartItem(id).map { it.toDomain() }
    }

    override suspend fun insertCartItem(cart: cart) {
        cartDao.InsertCartItem(cart.toEntity())
    }

    override suspend fun deleteCartItem(cart: cart) {
        cartDao.DeleteCartItem(cart.toEntity())
    }

    override suspend fun updateCartItem(cart: cart) {
        cartDao.UpdateCartItem(cart.toEntity())
    }
}