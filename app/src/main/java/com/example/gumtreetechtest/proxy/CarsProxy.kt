package com.example.gumtreetechtest.proxy

import com.example.gumtreetechtest.api.CarsApi
import javax.inject.Inject

class CarsProxy @Inject constructor(
    val api: CarsApi
){
    fun fetchCars() {
        api.fetchCars()
    }
}