package com.example.gumtreetechtest.proxy

import com.example.gumtreetechtest.api.CarsApi
import com.example.gumtreetechtest.domain.ApiResults
import com.example.gumtreetechtest.domain.SearchResults
import javax.inject.Inject

class CarsProxy @Inject constructor(
    val api: CarsApi
){
    suspend fun fetchCars(make:String,model:String,year:Int): List<SearchResults> {
        return api.fetchCars(make,model,year).searchResults
    }
}