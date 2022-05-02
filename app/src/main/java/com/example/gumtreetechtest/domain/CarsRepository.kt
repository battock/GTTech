package com.example.gumtreetechtest.domain

import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.networkStates.Result

interface CarsRepository{
    suspend fun fetchCars(make:String,model:String,year:String): Result<List<Car>>
}