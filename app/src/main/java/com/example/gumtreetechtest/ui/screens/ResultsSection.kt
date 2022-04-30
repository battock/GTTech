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
import com.example.gumtreetechtest.ui.components.DescriptionText
import com.example.gumtreetechtest.ui.components.ErrorText
import com.example.gumtreetechtest.ui.components.ScrollingList
import com.example.gumtreetechtest.ui.components.SubHeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.themes.Purple200
import com.example.gumtreetechtest.ui.viewmodels.ApiState
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

@Composable
fun ResultsSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.apiState.value
    val results = viewModel.resultsData.value

    Box(modifier = modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(horizontal = dimensionResource(id = R.dimen.standard_padding))
    ){
        when(state){
            ApiState.ERROR->{
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.medium_padding))
                ) {
                    DescriptionText(text = "Error fetching results")
                }
            }
            ApiState.SUCCESS->{
                ScrollingList(results)
            }
        }
    }

    Box(modifier = modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .padding(horizontal = dimensionResource(id = R.dimen.standard_padding))
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