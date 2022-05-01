package com.example.gumtreetechtest.ui.viewmodels

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.ValidationType
import com.example.gumtreetechtest.ui.models.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val carsRepository: CarsRepository,
    val inputValidation: InputValidator
) : ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    var apiState: MutableState<ApiState> = mutableStateOf(ApiState.LOADING)
        private set

    var selectedMake: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var selectedModel: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var selectedYear: MutableState<SearchInput> = mutableStateOf(SearchInput())
        private set

    var resultsData = mutableStateOf<List<Car>>(listOf())
        private set

    fun setMake(make: String) {
        selectedMake.value = SearchInput(data = make)
    }

    fun setModel(model: String) {
        selectedModel.value = SearchInput(data = model)
    }

    fun setYear(year: String) {
        selectedYear.value = SearchInput(data = year)
    }

    fun upDateResults() {
        val year = selectedYear.value.data
        val model = selectedModel.value.data
        val make = selectedMake.value.data

        if (validateInputs()) {
            viewModelScope.launch {
                val result = carsRepository.fetchCars(make, model, year)
                resultsData.value = when(result){
                    is Result.Error->{
                        apiState.value = ApiState.ERROR
                        emptyList()
                    }
                    is Result.Success ->{
                        apiState.value = ApiState.SUCCESS
                        result.data
                    }
                }
            }
        } else {
            resultsData.value = emptyList()
        }

    }

    @VisibleForTesting
    private fun validateInputs(): Boolean =
        validateMake() && validateModel() && validateYear()


    /*
    Validate make
     */
    private fun validateMake(): Boolean {
        if (!inputValidation.validate(selectedMake.value.data, ValidationType.MAKE)) {
            selectedMake.value = SearchInput(errorText = "input must be valid make")
            return false
        }
        return true
    }

    /*
     Validate year
    */
    private fun validateYear(): Boolean {
        if (!inputValidation.validate(selectedYear.value.data, ValidationType.YEAR)) {
            selectedYear.value = SearchInput(errorText = "input must be valid year")
            return false
        }
        return true
    }

    /*
    Validate model
    */
    private fun validateModel(): Boolean {
        if (!inputValidation.validate(selectedModel.value.data, ValidationType.MODEL)) {
            selectedModel.value = SearchInput(errorText = "input must be valid model")
            return false
        }
        return true
    }
}

data class SearchInput(
    val data: String = "",
    val errorText: String? = null
)