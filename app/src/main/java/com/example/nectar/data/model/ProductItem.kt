package com.example.nectar.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nectar.domain.model.product


@Entity(tableName = "Products")
data class ProductItem (
    @PrimaryKey (autoGenerate = true)
    var Id: Int = 0,
    val productName: String,
    val productWeight: String,
    var productImg: String,
    var productPrice: Float,
    var productDescription: String,
    var productCategory: String,
    var productRating: Int,
    var productNutrition: Nutrition
)

fun ProductItem.toDomain(): product {
    return product(
        Id = Id ,
        productName = productName,
        productWeight = productWeight,
        productImg = productImg,
        productPrice = productPrice,
        productDescription = productDescription,
        productCategory = productCategory,
        productNutrition = productNutrition,
        productRating = productRating
    )
}



// Nested JSON in the table, representing the nutritions
data class Nutrition(
    val protein: Float,
    val carbs: Float,
    val fat: Float,
    val fiber: Float
)