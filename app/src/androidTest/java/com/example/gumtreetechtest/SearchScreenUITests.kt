package com.example.gumtreetechtest

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gumtreetechtest.ui.screens.SearchSection
import com.example.gumtreetechtest.ui.screens.UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.networkStates.ApiState
import com.example.gumtreetechtest.ui.components.INPUT_VALIDATION_ERROR_TEXT
import com.example.gumtreetechtest.ui.viewmodels.InvalidText
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchScreenUITests {

    @get:Rule()
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = mockk()
        addMockResponses()
    }

    @Test
    fun updateResultsBtnClick_passesEventToViewModel() {
        setContent()
        composeTestRule.onNodeWithContentDescription(UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION)
            .performClick()
        verify { viewModel.upDateResults() }
    }

    @Test
    fun invalidMake_showsError() = runTest {
        val invalidMakeItem = mutableStateOf(SearchInput(invalidText = InvalidText.INVALID_MAKE))
        coEvery { viewModel.selectedMake } returns invalidMakeItem

        setContent()
        composeTestRule.onNodeWithContentDescription(INPUT_VALIDATION_ERROR_TEXT)
            .assertTextContains(InvalidText.INVALID_MAKE.title)
    }

    @Test
    fun invalidYear_showsError() {
        val invalidYearItem = mutableStateOf(SearchInput(invalidText = InvalidText.INVALID_YEAR))
        coEvery { viewModel.selectedYear } returns invalidYearItem

        setContent()
        composeTestRule.onNodeWithContentDescription(INPUT_VALIDATION_ERROR_TEXT)
            .assertTextContains(InvalidText.INVALID_YEAR.title)
    }

    @Test
    fun invalidModel_showsError() {
        val invalidModelItem = mutableStateOf(SearchInput(invalidText = InvalidText.INVALID_MODEL))
        coEvery { viewModel.selectedModel } returns invalidModelItem

        setContent()
        composeTestRule.onNodeWithContentDescription(INPUT_VALIDATION_ERROR_TEXT)
            .assertTextContains(InvalidText.INVALID_MODEL.title)
    }

//    @Test
//    fun allInputsValid_triggersApiCall() {
//        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
//    }
//
//    @Test
//    fun errorReturnedFromApi_ShowsErrorMessage() {
//        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
//    }
//
//    @Test
//    fun sucessfulResponseReturnedFromApi_ShowsListOfCars() {
//        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
//    }


    private fun addMockResponses() {
        coEvery { viewModel.setMake(any()) } returns Unit
        coEvery { viewModel.setModel(any()) } returns Unit
        coEvery { viewModel.setYear(any()) } returns Unit
        coEvery { viewModel.upDateResults() } returns Unit
        coEvery { viewModel.validateInputs() } returns true
        coEvery { viewModel.selectedMake.value } returns SearchInput(data = "")
        coEvery { viewModel.selectedModel.value } returns SearchInput(data = "")
        coEvery { viewModel.selectedYear.value } returns SearchInput(data = "")
        coEvery { viewModel.apiState.value } returns ApiState.SUCCESS
        coEvery { viewModel.resultsData.value } returns emptyList()
    }


    private fun setContent() {
        composeTestRule.setContent {
            GumTreeAppTheme {
                SearchSection(viewModel = viewModel)
            }
        }
    }
}