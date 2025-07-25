package com.example.nectar.DI

import com.example.nectar.data.repository.ProductLocalRepository
import com.example.nectar.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductRepository(
        impl: ProductLocalRepository
    ): ProductRepository

}