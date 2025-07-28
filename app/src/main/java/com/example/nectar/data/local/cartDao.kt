package com.example.nectar.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.nectar.data.model.CartItem
import kotlinx.coroutines.flow.Flow


@Dao
interface cartDao {

    @Query("SELECT * FROM cart")
    fun getAllCartItems(): Flow<List<CartItem>>

    @Query("SELECT * FROM cart WHERE cartId == :id ")
    fun getSpecificCartItem(id:Int): Flow<CartItem>

    @Insert
    suspend fun InsertCartItem(cartItem: CartItem)

    @Delete
    suspend fun DeleteCartItem(cartItem: CartItem)

    @Update
    suspend fun UpdateCartItem(cartItem: CartItem)


}