package com.example.gumtreetechtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import com.example.gumtreetechtest.ui.screens.ResultsScreen
import com.example.gumtreetechtest.ui.screens.SearchScreen
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GumTreeAppTheme {
                Scaffold {
                    ResultsScreen("Results!")
                }
            }
        }
    }
}
