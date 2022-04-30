package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.InputValidation
import com.example.gumtreetechtest.ui.ValidationType
import com.example.gumtreetechtest.ui.models.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val carsRepository: CarsRepository,
    val inputValidation: InputValidation
) : ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    var selectedMake: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var selectedModel: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var selectedYear: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var resultsData = mutableStateOf<List<Car>>(listOf())
        private set

    init {

    }

    fun setMake(make: String) {
        selectedMake.value = SearchInput(data = make)
        if(!inputValidation.validate(make,ValidationType.MAKE)){
            selectedMake.value = SearchInput(errorText = "invalid make entered")
        }
    }

    fun setModel(model: String) {
        selectedModel.value = SearchInput(data = model)
        if(!inputValidation.validate(input = model,ValidationType.MODEL)){
            selectedModel.value = SearchInput(errorText = "invalid model type entered")
        }
    }

    fun setYear(year: String) {
        selectedYear.value = SearchInput(data = year)
        if(!inputValidation.validate(year,ValidationType.YEAR)){
             selectedYear.value = SearchInput(errorText = "invalid year entered")
         }
    }

    fun upDateResults() {
        val year = selectedYear.value.data
        val model = selectedModel.value.data
        val make = selectedMake.value.data

        if (inputValidation.allInputsValid) {
            viewModelScope.launch {
                val result = carsRepository.fetchCars(make, model, year)
                resultsData.value = result
            }
        }
        else{
            resultsData.value = emptyList()
        }

    }
}

data class SearchInput(
    val data:String = "",
    val errorText:String? = null
)