package com.example.gumtreetechtest.ui.screens

import com.example.gumtreetechtest.R
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel


@Composable
fun MainScreen(
    navController: NavController? = null,
    viewModel: MainViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.standard_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
        {
            SearchSection()
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.small_padding)))
            ResultsSection()
        }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GumTreeAppTheme {
        MainScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkPreview() {
    GumTreeAppTheme {
        MainScreen()
    }
}