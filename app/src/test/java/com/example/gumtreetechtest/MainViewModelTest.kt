package com.example.gumtreetechtest

import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainViewModelTest {


    @MockK
    private lateinit var repository:CarsRepository

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init()
        viewModel = MainViewModel(repository)
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}