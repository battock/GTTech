package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.models.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val carsRepository: CarsRepository
) : ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    var _selectedMake: MutableState<String> = mutableStateOf("")
        private set

    var _selectedModel: MutableState<String> = mutableStateOf("")
        private set

    var _selectedYear: MutableState<String> = mutableStateOf("")
        private set

    var resultsData = mutableStateOf<List<Car>>(listOf())
        private set

    init {

    }

    fun setMake(make: String) {
        _selectedMake.value = make
    }

    fun setModel(model: String) {
        _selectedModel.value = model
    }

    fun setYear(year: String) {
        _selectedYear.value = year
    }

    fun upDateResults() {
        val year = _selectedYear.value ?: ""
        val model = _selectedModel.value ?: ""
        val make = _selectedMake.value ?: ""

        if (make.length > 0 && model.length > 0 && year.length > 0) {
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

