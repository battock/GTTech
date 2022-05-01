package com.example.gumtreetechtest.di

import com.example.gumtreetechtest.ui.InputValidator
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
    fun provideInputValidator(): InputValidator {
        return InputValidator()
    }
}