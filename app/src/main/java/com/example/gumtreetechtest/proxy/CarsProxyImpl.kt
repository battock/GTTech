package com.example.gumtreetechtest.proxy

import com.example.gumtreetechtest.api.CarsApi
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.utils.logging
import java.lang.Exception
import javax.inject.Inject

class CarsProxyImpl @Inject constructor(
    val api: CarsApi
):CarsProxy {
    val LOGGING_TAG by lazy { this.javaClass.simpleName }

    override suspend fun fetchCars(make: String, model: String, year: String): Result<List<Car>> {
        return try {
            val results = api.fetchCars(make, model, year)
            Result.Success(
                data = results!!.searchResults!!.map {
                    Car(
                        make = it.make,
                        model = it.model,
                        name = it.name,
                        title = it.title,
                        year = it.year,
                        price = it.price
                    )
                })
        } catch (ex: Exception) {
            logging(LOGGING_TAG, "error fetching car data")
            Result.Error(exception = ex)
        }
    }
}