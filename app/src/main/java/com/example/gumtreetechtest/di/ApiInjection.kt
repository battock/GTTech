package com.example.gumtreetechtest.di

import android.app.Application
import com.example.gumtreetechtest.GumTree
import com.example.gumtreetechtest.api.CarsApi
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiInjection {

    @Singleton
    @Provides
    fun provideCarsService():CarsApi{
        return Retrofit.Builder()
            .baseUrl("http://ghghjj.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}