package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.ScrollingList
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.themes.Purple200
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

@Composable
fun ResultsSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val results = viewModel.resultsData.value

    Box(modifier = modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .border(2.dp,
            color = Purple200,
            RectangleShape
        )
    ) {
        ScrollingList(results)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultResultsPreview() {
    GumTreeAppTheme {
        //ResultsSection()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkResultsPreview() {
    GumTreeAppTheme {
        //ResultsSection()
    }
}