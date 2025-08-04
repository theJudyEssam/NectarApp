package com.example.nectar.domain.model

import com.example.nectar.data.model.Nutrition
import com.example.nectar.data.model.ProductItem

class product(
    val Id: Int = 0,
    val productName: String,
    val productWeight: String,
    val productImg: String,
    val productPrice: Float,
    val productDescription: String,
    val productCategory: String,
    val productNutrition: Nutrition,
    val productRating: Int
)

fun product.toEntity(): ProductItem {
    return ProductItem(
        Id = Id,
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