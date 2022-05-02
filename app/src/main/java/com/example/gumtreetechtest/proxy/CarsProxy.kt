package com.example.gumtreetechtest.proxy

import com.example.gumtreetechtest.networkStates.Result
import com.example.gumtreetechtest.ui.models.Car

interface CarsProxy{
    suspend fun fetchCars(make: String, model: String, year: String): Result<List<Car>>
}