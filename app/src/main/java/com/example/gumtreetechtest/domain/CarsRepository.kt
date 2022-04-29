package com.example.gumtreetechtest.domain

import com.example.gumtreetechtest.proxy.CarsProxy
import javax.inject.Inject

class CarsRepository @Inject constructor(
    val proxy: CarsProxy
){
    fun fetchCars(make:String,model:String,year:Int){

        proxy.fetchCars()

    }


}