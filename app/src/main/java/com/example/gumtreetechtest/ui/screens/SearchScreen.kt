package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.SearchScreenViewModel


@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel
){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderText(
            text = "searchScreenTitleTxt"
        )
        Button(
            onClick = {}) {
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GumTreeAppTheme {
        //SearchScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    GumTreeAppTheme {
        //SearchScreen()
    }
}