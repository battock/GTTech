package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    var year = mutableStateOf("-")
        private set

    var make = mutableStateOf("-")
        private set

    var model = mutableStateOf("-")
        private set

    var resultsData = mutableStateOf<List<String>>(listOf())
        private set


    init {
        resultsData.value = List(100) { i -> "Header $i" }
    }

}