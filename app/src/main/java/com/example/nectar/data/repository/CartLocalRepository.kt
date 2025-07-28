package com.example.nectar.data.repository

import com.example.nectar.data.local.Dao.cartDao
import com.example.nectar.data.model.CartItem
import com.example.nectar.data.model.toDomain
import com.example.nectar.domain.model.cart
import com.example.nectar.domain.model.product
import com.example.nectar.domain.model.toEntity
import com.example.nectar.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartLocalRepository
@Inject constructor(private val cartDao: cartDao): CartRepository {

    // Three functions for accessing the database, in different ways

    override fun getAllCartItems(): Flow<List<cart>> {
        return cartDao.getAllCartItems().map {
            list -> list.map{ it.toDomain()}
        }
    }

    override fun observeCartItem(id: Int): Flow<cart?> {
        val cartItem = cartDao.observeCartItem(id).map{it?.toDomain()}
        return cartItem
    }

    override suspend fun getCartItem(id: Int): cart? {
        val cartItem = cartDao.getSpecificCartItem(id)?.toDomain()
        return cartItem
    }


    // Three "helper functions" to be used within the useCase
    override suspend fun insertCartItem(cart: cart) {
        cartDao.InsertCartItem(cart.toEntity())
    }

    override suspend fun deleteCartItem(cart: cart) {
        cartDao.DeleteCartItem(cart.toEntity())
    }

    override suspend fun updateCartItem(cart: cart) {
        cartDao.UpdateCartItem(cart.toEntity())
    }


    // Three functions for Cart actions such as adding, deleting, incrementing, and decrementing
    override suspend fun toggleCartItem(product: product) {
        val item = getCartItem(product.Id) // check if existing
        if(item != null){
            deleteCartItem(item)
        }
        else{
            val new_item = cart(
                product = product,
                quantity = 1,
                productId = product.Id
            )
            insertCartItem(new_item)
        }
    }

    override suspend fun incrementCartItem(product: product){
        val item = getCartItem(product.Id)
        if(item != null){
            val updated = item.copy(quantity = item.quantity + 1)
            updateCartItem(updated)
        }
        else{
            val new_item = cart(product = product, quantity = 1, productId = product.Id)
            insertCartItem(new_item)
        }
    }

    override suspend fun decrementCartItem(product: product){
        val item = getCartItem(product.Id)
        if(item != null){
            if(item.quantity > 1){
                val updated = item.copy(quantity = item.quantity - 1)
                updateCartItem(updated)
            }
            else{
                deleteCartItem(item)
            }
        }
    }
}