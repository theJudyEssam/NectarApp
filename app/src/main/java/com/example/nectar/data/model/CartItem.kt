package com.example.nectar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nectar.domain.model.cart


@Entity(tableName = "cart")
data class CartItem(
    @PrimaryKey (autoGenerate = true)
    val cartId: Int = 0,
    val quantity:Int = 0,
    val productId:Int, // the choice of productId in CartItem (for lesser complexity
    val product: ProductItem
)

fun CartItem.toDomain(): cart {
    return cart(
        cartId =cartId,
        quantity = quantity,
        productId = productId,
        product = product.toDomain()
    )
}