package com.example.gumtreetechtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.network.Result
import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.ValidationType
import com.example.gumtreetechtest.ui.viewmodels.InvalidText
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
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
    fun invalidMakeTriggersValidationError_whenupdateResultsIsClicked() = runTest{
        every { inputValidator.validate(any(), ValidationType.MAKE) } returns false
        this.launch {
            val expectedResult =  SearchInput(invalidText = InvalidText.INVALID_MAKE)
            viewModel.upDateResults()
            val actualResult = viewModel.selectedMake.value

            assert(expectedResult==actualResult)
            viewModel.upDateResults()
        }
    }

    @Test
    fun invalidModelTriggersValidationError_whenupdateResultsIsClicked() = runTest{
        every { inputValidator.validate(any(), ValidationType.MODEL) } returns false
        this.launch {
            val expectedResult = SearchInput(invalidText = InvalidText.INVALID_MODEL)
            viewModel.upDateResults()
            val actualResult = viewModel.selectedModel.value

            assert(expectedResult==actualResult)
            viewModel.upDateResults()
        }
    }

    @Test
    fun invalidYearTriggersValidationError_whenupdateResultsIsClicked() = runTest{
        every { inputValidator.validate(any(), ValidationType.YEAR) } returns false
        this.launch {
            val expectedResult = SearchInput(invalidText = InvalidText.INVALID_YEAR)
            viewModel.upDateResults()
            val actualResult = viewModel.selectedYear.value

            assert(expectedResult==actualResult)
            viewModel.upDateResults()
        }
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


