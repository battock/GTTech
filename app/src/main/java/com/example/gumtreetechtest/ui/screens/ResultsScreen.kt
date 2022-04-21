package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme

@Composable
fun ResultsScreen(
    navController: NavController,
    resultsScreenTitleTxt: String = "RESULTS",
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(1) {
            (0..200).forEach {
                HeaderText(
                    text = "$resultsScreenTitleTxt number $it"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultResultsPreview() {
    GumTreeAppTheme {
        //ResultsScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkResultsPreview() {
    GumTreeAppTheme {
        //ResultsScreen()
    }
}