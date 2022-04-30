package com.example.gumtreetechtest.di

import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.domain.CarsRepositoryImpl
import com.example.gumtreetechtest.proxy.CarsProxy
import com.example.gumtreetechtest.proxy.CarsProxyImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface Bindings{
    @Binds
    @Singleton
    fun provideMyProxy(carProxy: CarsProxyImpl): CarsProxy

    @Binds
    @Singleton
    fun provideMyRepo(carRepo: CarsRepositoryImpl): CarsRepository

}