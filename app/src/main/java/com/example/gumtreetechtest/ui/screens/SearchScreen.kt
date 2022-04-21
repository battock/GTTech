package com.example.gumtreetechtest.ui.screens

import com.example.gumtreetechtest.R
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.SearchScreenViewModel


@Composable
fun SearchScreen(
    navController: NavController,
    viewModel: SearchScreenViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(0.99f)
                .padding(dimensionResource(id = R.dimen.standard_padding)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.End
        )
        {
            HeaderText(
                text = "Search..."
            )
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