package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.DescriptionText
import com.example.gumtreetechtest.ui.components.ScrollingList
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.network.ApiState
import com.example.gumtreetechtest.ui.components.ErrorText
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
                        .padding(
                            dimensionResource(id = R.dimen.medium_padding)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    ErrorText(text = stringResource(R.string.error_fetching_cars_txt))
                }
            }
            ApiState.SUCCESS->{
                ScrollingList(results)
            }
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.large_padding)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            DescriptionText(text = stringResource(R.string.update_search_txt), color = MaterialTheme.colors.surface)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultResultsPreview() {
    GumTreeAppTheme {
        ResultsSection()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkResultsPreview() {
    GumTreeAppTheme {
        ResultsSection()
    }
}