package com.example.nectar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nectar.data.model.CartItem
import com.example.nectar.data.model.ProductItem

@Database(entities = [ProductItem::class, CartItem::class], version = 1, exportSchema = false)
@TypeConverters(ProductConverters::class, CartConverters::class)
abstract class AppDatabase: RoomDatabase(){
    abstract fun productDao(): productDao
    abstract fun cartDao(): cartDao
}