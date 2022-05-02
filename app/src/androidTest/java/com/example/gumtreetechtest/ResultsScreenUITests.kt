package com.example.gumtreetechtest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gumtreetechtest.ui.screens.*
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.network.ApiState
import com.example.gumtreetechtest.ui.components.RESULTS_SECTION_DESCRIPTION
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ResultsScreenUITests {

    @get:Rule()
    val composeTestRule = createComposeRule()

    @MockK
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
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

    }


    @Test
    fun noDataText_shown() {
        every { viewModel.apiState.value } returns ApiState.LOADING
        setContent(viewModel)

        composeTestRule.onNodeWithText("Update your search to see some cars")
            .assertIsDisplayed()
    }

    @Test
    fun dataErrorText_shown() {
        every { viewModel.apiState.value } returns ApiState.ERROR
        setContent(viewModel)

        composeTestRule.onNodeWithText("Error fetching cars")
            .assertIsDisplayed()
    }

    @Test
    fun dataSuccess_ListOfCarsShown() {
        every { viewModel.apiState.value } returns ApiState.SUCCESS
        setContent(viewModel)

        composeTestRule.onAllNodes(hasAnyChild(hasContentDescription(RESULTS_SECTION_DESCRIPTION)))
    }

    private fun setContent(viewModel: MainViewModel) {
        composeTestRule.setContent {
            GumTreeAppTheme {
                ResultsSection(viewModel = viewModel)
            }
        }
    }
}

