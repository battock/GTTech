package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    private val _year: MutableLiveData<Int> = MutableLiveData(2022)
    val year:LiveData<Int> = _year

    private val _make: MutableLiveData<Make> = MutableLiveData(Make.Ford)
    val make:LiveData<Make> = _make

    private val _model: MutableLiveData<Model> = MutableLiveData(Model.Focus)
    val model:LiveData<Model> = _model

    var resultsData = mutableStateOf<List<String>>(listOf())
        private set


    init {
        resultsData.value = List(100) { i -> "Header $i" }
    }


    fun setMake(make:Make) {
        _make.postValue(Make.Ford)
    }

    fun setModel(model:Model) {
        _model.postValue(Model.Focus)
    }

    fun setYear(year:Int) {
        _year.postValue(2022)
    }


}

//todo...temp until proper data
enum class Make {
    Ford,
    Renault,
    Tesla
}
enum class Model{
    Focus,
    Clio,
    Tesla_2
}