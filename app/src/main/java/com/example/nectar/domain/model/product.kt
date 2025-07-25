package com.example.nectar.domain.model

import com.example.nectar.data.model.ProductItem

class product(
    var Id: Int = 0,
    var productName: String,
    var productWeight: String,
    var productImg: String,
    var productPrice: Float,
    var productDescription: String,
    var productCategory: String,
    var productNutrition: String,
    var productRating: Int
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