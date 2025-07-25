package com.example.nectar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nectar.data.model.ProductItem

@Database(entities = [ProductItem::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun productDao(): productDao
}