package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.Image
import com.example.gumtreetechtest.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

@Composable
fun MainScreen(
    viewModel:MainViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.standard_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
        {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.medium_padding)))
            Image(
                painterResource(R.drawable.motors),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .semantics {
                        contentDescription = MOTORSCOUK_IMAGE
                    }
                    .width(dimensionResource(id = R.dimen.logo_width))
                    .height(dimensionResource(id = R.dimen.logo_height))
            )
            SearchSection(viewModel =viewModel)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.small_padding)))
            ResultsSection(viewModel =viewModel)
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

const val MOTORSCOUK_IMAGE = "motors.co.uk_image"