package com.example.gumtreetechtest.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(): ViewModel() {

    private val LOGGING_TAG by lazy { this.javaClass.simpleName }

    private var _year = mutableStateOf("-")
    val year = _year

    private var _make = mutableStateOf("-")
    val make = _make

    private var _model = mutableStateOf("-")
    val model = _model



}