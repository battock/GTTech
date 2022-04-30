package com.example.gumtreetechtest.api

import com.example.gumtreetechtest.domain.ApiResults
import com.example.gumtreetechtest.domain.SearchResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CarsApi {

    @GET("search?")
    suspend fun fetchCars(
        @Query("make") make:String,
        @Query("model") model:String,
        @Query("year") year:String
    ): ApiResults
}