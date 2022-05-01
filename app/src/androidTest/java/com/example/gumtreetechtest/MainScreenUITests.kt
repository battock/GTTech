package com.example.gumtreetechtest

import android.app.Application
import androidx.activity.viewModels
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.gumtreetechtest.domain.CarsRepository
import com.example.gumtreetechtest.ui.InputValidator
import com.example.gumtreetechtest.ui.screens.MainScreen
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import dagger.hilt.android.testing.CustomTestApplication
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
class MainScreenUITests {

    @get:Rule(order = 2)
    val composeTestRule = createComposeRule()

    val mockRepo:CarsRepository = mockk()
    val mockValidator:InputValidator = mockk()

    val viewModel = MainViewModel(mockRepo,mockValidator)


    @Before
    fun setUp(){
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

@CustomTestApplication(Application::class)
interface HiltTestApplication