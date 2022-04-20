package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    searchScreenTitleTxt:String = "SEARCH"
){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeaderText(
            text = searchScreenTitleTxt
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GumTreeAppTheme {
        SearchScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    GumTreeAppTheme {
        SearchScreen()
    }
}