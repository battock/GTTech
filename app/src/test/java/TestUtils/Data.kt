package TestUtils

import android.app.appsearch.SearchResult
import com.example.gumtreetechtest.domain.SearchResults
import com.example.gumtreetechtest.ui.models.Car

val listOfCars by lazy {
    listOf(
        Car(
            name = "A Car",
            title = "Very nice car",
            make = "Ford",
            model = "Focus",
            year = "2019",
            price = "£432.33"
        )
    )
}

val listOfSearchResults by lazy {
    listOf(
        SearchResults(
            id = "",
            name = "A Car",
            title = "Very nice car",
            make = "Ford",
            model = "Focus",
            year = "2019",
            price = "£432.33"
        )
    )
}

val invalidSearchResultsList by lazy{
    listOf(
        1,2,3,4
    )
}