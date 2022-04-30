package com.example.gumtreetechtest

import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.InputValidation
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import org.junit.Test
import com.example.gumtreetechtest.network.Result
import io.mockk.*
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MainViewModelTest {

    @RelaxedMockK
    private lateinit var repository: CarsRepository

    @RelaxedMockK
    private lateinit var inputValidation: InputValidation

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init()
        viewModel = MainViewModel(repository, inputValidation)
        val data = TestUtils.listOfCars
        coEvery { repository.fetchCars(any(), any(), any()) } returns Result.Success(data)
        every { viewModel.inputValidation.validate(any(), any()) } returns true
    }


    @Test
    fun textBoxesAreValidated_whenupdateResultsIsClicked() = runTest {
        assert(false)
    }

    @Test
    fun invalidMakeTriggersValidationError_whenupdateResultsIsClicked() {
        assert(false)
    }

    @Test
    fun invalidModelTriggersValidationError_whenupdateResultsIsClicked() {
        assert(false)
    }

    @Test
    fun invalidYearTriggersValidationError_whenupdateResultsIsClicked() {
        assert(false)
    }

    @Test
    fun anyInvalidFieldPreventsApiCall_whenupdateResultsIsClicked() {
        assert(false)
    }

    @Test
    fun allValidFieldsCallsRepo_whenupdateResultsIsClicked() = runTest {
        this.launch {
            viewModel.upDateResults()
        }
        coVerify { repository.fetchCars(any(), any(), any()) }
    }
}


