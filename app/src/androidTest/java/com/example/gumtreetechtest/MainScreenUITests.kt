package com.example.gumtreetechtest

import android.app.Application
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.screens.MainScreen
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.ApiState
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import com.example.gumtreetechtest.ui.viewmodels.SearchInput
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltTestApplication
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
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
    fun mainTitle_isShown() {
        composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }
}
