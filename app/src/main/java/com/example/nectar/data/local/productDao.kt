package com.example.nectar.data.local

import androidx.room.Dao
import androidx.room.Query
import com.example.nectar.data.model.ProductItem
import kotlinx.coroutines.flow.Flow


@Dao
interface productDao {


    @Query("Select * From Products")
    fun getAllProducts(): Flow<List<ProductItem>>

    @Query("SELECT * FROM Products WHERE productCategory == :category")
    fun getCategoryProducts(category: String): Flow<List<ProductItem>>

    @Query("Select * From Products Where productName LIKE :name")
    fun SearchProductbyName(name:String): Flow<List<ProductItem>>

    @Query("Select * From Products Where id == :id")
    fun GetSpecificProduct(id: Int): Flow<ProductItem>
}