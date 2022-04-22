package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.components.DescriptionText
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme


@Composable
fun InfoScreen(
    navController: NavController?
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
        {
            HeaderText(text = "Info screen")
            DescriptionText(text = "A screen with some extra information...")
            Button(onClick = { /*TODO*/ }) {
                navController?.popBackStack()
            }
        }
}


@Preview(showBackground = true)
@Composable
fun DefaultInfoScreenPreview() {
    GumTreeAppTheme {
        InfoScreen(null)
    }
}

@Preview(showBackground = true)
@Composable
fun DarkInfoScreenPreview() {
    GumTreeAppTheme {
        InfoScreen(null)
    }
}