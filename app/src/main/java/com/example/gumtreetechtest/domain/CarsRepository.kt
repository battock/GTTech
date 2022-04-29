package com.example.gumtreetechtest.domain

import com.example.gumtreetechtest.proxy.CarsProxy
import javax.inject.Inject

class CarsRepository @Inject constructor(
    val proxy: CarsProxy
){
    suspend fun fetchCars(make:String,model:String,year:Int):List<SearchResults>{
        return proxy.fetchCars(make,model,year)
    }


}