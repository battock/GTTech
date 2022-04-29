package com.example.gumtreetechtest.proxy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gumtreetechtest.api.CarsApi
import com.example.gumtreetechtest.domain.ApiResults
import com.example.gumtreetechtest.domain.SearchResults
import com.example.gumtreetechtest.ui.models.Car
import javax.inject.Inject

class CarsProxy @Inject constructor(
    val api: CarsApi
){
    suspend fun fetchCars(make:String,model:String,year:Int): List<Car> {
        return api.fetchCars(make,model,year).searchResults.map {
            Car(
                make = it.make,
                model = it.model,
                name = it.name,
                title = it.title,
                year = it.year,
                price = it.price,
                image = Icons.Default.ShoppingCart
            )
        }
    }
}