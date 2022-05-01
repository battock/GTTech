package com.example.gumtreetechtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MainViewModelTest {

    @RelaxedMockK
    private lateinit var repository: CarsRepository

    @RelaxedMockK
    private lateinit var inputValidator: InputValidator

    @RelaxedMockK
    private lateinit var testDispatcher: TestDispatcher

    private lateinit var viewModel: MainViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = MainViewModel(repository, inputValidator)
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
    fun anyInvalidFieldPreventsApiCall_whenupdateResultsIsClicked() = runTest{
        every { inputValidator.validate(any(), any()) } returns false
        this.launch {
            assert(viewModel.resultsData.value.isEmpty())
            viewModel.upDateResults()
            assert(viewModel.resultsData.value.isEmpty())
        }
    }

    @Test
    fun allValidFieldsCallsRepo_whenupdateResultsIsClicked() = runTest {
        every { inputValidator.validate(any(), any()) } returns true
        this.launch {
            viewModel.upDateResults()
            coVerify { repository.fetchCars(any(), any(), any()) }
        }
    }

    @Test
    fun viewModelassesApiDataToView_whenupdateSuccessfulApiDataReturned() = runTest {
        every { inputValidator.validate(any(), any()) } returns true
        this.launch {
            assert(viewModel.resultsData.value.isEmpty())
            viewModel.upDateResults()
            assert(viewModel.resultsData.value.isNotEmpty())
        }
    }
}


