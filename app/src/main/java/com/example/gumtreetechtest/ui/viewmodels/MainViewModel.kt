package com.example.gumtreetechtest.ui.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.key
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.*
import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.ui.models.Make
import com.example.gumtreetechtest.ui.models.Model
import com.example.gumtreetechtest.utils.mockAvailableCars
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    /**
     * For use in api call
     */
    private val _selectedYear: MutableLiveData<Int> = MutableLiveData(2022)
    val year: LiveData<Int> = _selectedYear

    private val _selectedMake: MutableLiveData<String> = MutableLiveData("")
    val make: LiveData<String> = _selectedMake

    private val _selectedModel: MutableLiveData<String> = MutableLiveData()
    val model: LiveData<String> = _selectedModel

    private val _availableCars: MutableLiveData<HashMap<String, List<Model>>> =
        MutableLiveData(HashMap())

    /**
     * Below populate the drop down lists for search
     */
    val availableMakes:LiveData<List<String>> = _availableCars.map {
            it.keys.toList()
    }

    var availableModels:LiveData<List<String>> =_selectedMake.map {
        _availableCars.value?.getOrDefault(_selectedMake.value.toString(), emptyList())?.map { it.toString() }?: emptyList()
    }

    var availableYears: LiveData<List<String>> = liveData {  List(6) { i -> 2016 + i }.map { it.toString() } }


    var resultsData = mutableStateOf<List<Car>>(listOf())
        private set

    init {
        //fake data to poppulate drop downs and search results
        _availableCars.postValue(mockAvailableCars)
    }

    fun setMake(make: String) {
        if(_availableCars.value!!.containsKey(make.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(
                    Locale.getDefault()
                ) else it.toString()
            })){
            _selectedMake.postValue(make)
        }
    }

    fun setModel(model: String) {
        _selectedModel.postValue(model)
    }

    fun setYear(year: Int) {
        _selectedYear.postValue(2022)
    }
}

