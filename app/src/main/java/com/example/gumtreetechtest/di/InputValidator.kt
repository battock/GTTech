package com.example.gumtreetechtest.di

import com.example.gumtreetechtest.api.CarsApi
import com.example.gumtreetechtest.ui.InputValidation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InputValidatorInjection {
    @Singleton
    @Provides
    fun provideInputValidator(): InputValidation {
        return InputValidation()
    }
}