package com.example.nectar.domain.model

import com.example.nectar.data.local.CartConverters
import com.example.nectar.data.model.CartItem


data class cart (
    val cartId: Int = 0,
    val quantity:Int = 0,
    val productId:Int,
    val product: product
    )


fun cart.toEntity(): CartItem {
    return CartItem(
        cartId =cartId,
        quantity = quantity,
        productId = productId,
        product = product.toEntity()
    )
}