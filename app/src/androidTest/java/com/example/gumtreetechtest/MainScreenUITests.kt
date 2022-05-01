package com.example.gumtreetechtest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.gumtreetechtest.ui.screens.MainScreen
import com.example.gumtreetechtest.ui.screens.SearchSection
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainScreenUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @RelaxedMockK
    private lateinit var viewModel:MainViewModel

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
    }

    @Test
    fun mainTitle_isShown() {
        composeTestRule.setContent {
            GumTreeAppTheme{
                MainScreen(viewModel = viewModel)
            }
        }
        composeTestRule.onNodeWithText("Motors.co.uk").assertIsDisplayed()
    }
}