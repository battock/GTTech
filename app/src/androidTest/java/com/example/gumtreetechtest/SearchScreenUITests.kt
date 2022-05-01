package com.example.gumtreetechtest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gumtreetechtest.ui.screens.MAKE_INPUT_FIELD_DESCRIPTION
import com.example.gumtreetechtest.ui.screens.SearchSection
import com.example.gumtreetechtest.ui.screens.UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.ApiState
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchScreenUITests {

    @get:Rule(order = 2)
    val composeTestRule = createComposeRule()

    @MockK
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        coEvery { viewModel.setMake(any()) } returns Unit
        coEvery { viewModel.setModel(any()) } returns Unit
        coEvery { viewModel.setYear(any()) } returns Unit

        coEvery { viewModel.selectedMake.value } returns SearchInput()
        coEvery { viewModel.selectedModel.value } returns SearchInput()
        coEvery { viewModel.selectedYear.value } returns SearchInput()
        coEvery { viewModel.apiState.value } returns ApiState.SUCCESS
        coEvery { viewModel.resultsData.value } returns emptyList()

        composeTestRule.setContent {
            GumTreeAppTheme {
                SearchSection(viewModel = viewModel)
            }
        }
    }

    @Test
    fun invalidMake_showsErrorBox() {

        composeTestRule.onNodeWithContentDescription(MAKE_INPUT_FIELD_DESCRIPTION)
            .performTextInput("")

        composeTestRule.onNodeWithContentDescription(UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION)
            .performClick()

        //composeTestRule.onNodeWithContentDescription(MAKE_INPUT_FIELD_DESCRIPTION_SUFFIX)
          //  .assertTextContains("invalid")
        }

    @Test
    fun invalidModel_showsErrorBox() {
        composeTestRule.onNodeWithContentDescription(UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION)
            .assertIsDisplayed()
    }

    @Test
    fun invalidTime_showsErrorBox() {
        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }

    @Test
    fun allInputsValid_triggersApiCall() {
        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }

    @Test
    fun errorReturnedFromApi_ShowsErrorMessage() {
        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }

    @Test
    fun sucessfulResponseReturnedFromApi_ShowsListOfCars() {
        //composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }


}
