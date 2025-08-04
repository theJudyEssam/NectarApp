package com.example.nectar.data.local

import androidx.room.TypeConverter
import com.example.nectar.data.model.Nutrition
import com.example.nectar.data.model.ProductItem
import com.google.gson.Gson


// For adding a Nutrition Obj in the Database
class ProductConverters {
    @TypeConverter
    fun fromNutrition(nutrition: Nutrition): String{
        return Gson().toJson(nutrition)
    }

    @TypeConverter
    fun toNutrition(json: String): Nutrition {
        return Gson().fromJson(json, Nutrition::class.java)
    }
}


// For adding a product item in the database.
class CartConverters{
    @TypeConverter
    fun fromProduct(product: ProductItem): String{
        return Gson().toJson(product)
    }

    @TypeConverter
    fun toProduct(json:String): ProductItem{
        return Gson().fromJson(json, ProductItem::class.java)
    }
}