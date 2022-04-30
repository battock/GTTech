package com.example.gumtreetechtest.domain

import com.example.gumtreetechtest.proxy.CarsProxy
import com.example.gumtreetechtest.ui.models.Car
import javax.inject.Inject

class CarsRepository @Inject constructor(
    val proxy: CarsProxy
){
    suspend fun fetchCars(make:String,model:String,year:String):List<Car>{
        return proxy.fetchCars(make,model,year)
    }


}