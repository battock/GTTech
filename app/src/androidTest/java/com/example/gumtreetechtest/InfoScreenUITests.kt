package com.example.gumtreetechtest

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.gumtreetechtest.ui.screens.*
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.networkStates.ApiState
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
class InfoScreenUITests {

    @get:Rule()
    val composeTestRule = createComposeRule()


    @Before
    fun setUp(){
        composeTestRule.setContent {
            GumTreeAppTheme{
                InfoScreen()
            }
        }
    }

    @Test
    fun mainTitle_shown() {
        composeTestRule.onNodeWithText("Info screen")
            .assertIsDisplayed()
    }
}

