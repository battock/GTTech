package com.example.gumtreetechtest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gumtreetechtest.ui.screens.*
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.network.ApiState
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
class MainScreenUITests {

    @get:Rule(order = 2)
    val composeTestRule = createComposeRule()

    @MockK
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        coEvery { viewModel.setMake(any()) } returns Unit
        coEvery { viewModel.setModel(any()) } returns Unit
        coEvery { viewModel.setYear(any()) } returns Unit
        coEvery { viewModel.upDateResults() } returns Unit

        coEvery { viewModel.selectedMake.value } returns SearchInput()
        coEvery { viewModel.selectedModel.value } returns SearchInput()
        coEvery { viewModel.selectedYear.value } returns SearchInput()
        coEvery { viewModel.apiState.value } returns ApiState.SUCCESS
        coEvery { viewModel.resultsData.value } returns emptyList()

        composeTestRule.setContent {
            GumTreeAppTheme{
                MainScreen(viewModel)
            }
        }
    }

    @Test
    fun mainTitle_shown() {
        composeTestRule.onNodeWithText("Motors.co.uk")
            .assertIsDisplayed()
    }

    @Test
    fun makeInputField_shown() {
        composeTestRule.onNodeWithContentDescription(MAKE_INPUT_FIELD_DESCRIPTION)
            .assertIsDisplayed()
    }

    @Test
    fun modelInputField_shown() {
        composeTestRule.onNodeWithContentDescription(MODEL_INPUT_FIELD_DESCRIPTION)
            .assertIsDisplayed()
    }

    @Test
    fun yearInputField_shown() {
        composeTestRule.onNodeWithContentDescription(YEAR_INPUT_FIELD_DESCRIPTION)
            .assertIsDisplayed()
    }


}

