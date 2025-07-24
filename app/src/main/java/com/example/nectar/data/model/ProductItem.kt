package com.example.nectar.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Products")
data class ProductItem (
    @PrimaryKey
    var Id: Int,
    var productName: String,
    var productWeight: String,
    var productImg: String,
    var productPrice: Float,
    var productDescription: String,
    var productCategory: String,
    var productNutrition: String,
    var productQuantity: Int,
    var productRating: Int
)