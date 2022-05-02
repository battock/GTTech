package com.example.gumtreetechtest.domain

import com.example.gumtreetechtest.proxy.CarsProxy
import com.example.gumtreetechtest.ui.models.Car
import javax.inject.Inject
import com.example.gumtreetechtest.networkStates.Result

class CarsRepositoryImpl @Inject constructor(
    val proxy: CarsProxy
):CarsRepository{
    override suspend fun fetchCars(make:String, model:String, year:String): Result<List<Car>> {
        return proxy.fetchCars(make,model,year)
    }
}