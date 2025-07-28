package com.example.nectar.DI

import android.content.Context
import androidx.room.Room
import com.example.nectar.data.local.AppDatabase
import com.example.nectar.data.local.cartDao
import com.example.nectar.data.local.productDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



// for getting the database
@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_db"
        )
        .fallbackToDestructiveMigration() // this is v bad practice, not to be used in production
        .build()


    @Provides
    fun provideProductDao(db: AppDatabase): productDao = db.productDao()

    @Provides
    fun provideCartDao(db: AppDatabase): cartDao = db.cartDao()
}
