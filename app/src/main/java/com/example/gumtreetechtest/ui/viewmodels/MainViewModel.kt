package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }


    /**
     * For use in api call
     */
    private val _selectedYear: MutableLiveData<Int> = MutableLiveData(2022)
    val year:LiveData<Int> = _selectedYear

    private val _selectedMake: MutableLiveData<Make> = MutableLiveData(Make.Ford)
    val make:LiveData<Make> = _selectedMake

    private val _selectedModel: MutableLiveData<Model> = MutableLiveData(Model.Focus)
    val model:LiveData<Model> = _selectedModel

    /**
     * Below poulate the drop dow lists for search
     */
    var availableMakes = mutableStateOf<List<Make>>(listOf())
        private set

    var availableModels = mutableStateOf<List<Model>>(listOf())
        private set

    var availableYears = mutableStateOf<List<Int>>(listOf())
        private set

    var resultsData = mutableStateOf<List<String>>(listOf())
        private set


    init {
        //fake data to poppulate drop downs and search results
        availableMakes.value = listOf(Make.Ford,Make.Renault)
        availableModels.value = listOf(Model.Focus,Model.Clio)
        availableYears.value = List(10) { i -> 2020+i }
        resultsData.value = List(100) { i -> "Header $i" }

    }


    fun setMake(make:Make) {
        _selectedMake.postValue(Make.Ford)
    }

    fun setModel(model:Model) {
        _selectedModel.postValue(Model.Focus)
    }

    fun setYear(year:Int) {
        _selectedYear.postValue(2022)
    }


}

//todo...temp until proper data
enum class Make {
    Ford,
    Renault
}
enum class Model{
    Focus,
    Clio
}