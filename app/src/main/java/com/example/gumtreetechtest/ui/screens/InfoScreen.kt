package com.example.gumtreetechtest.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.DescriptionText
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme

@Composable
fun InfoScreen(
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding),
                vertical = dimensionResource(id = R.dimen.small_padding)
            )
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,

    )
        {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))
            HeaderText(text = stringResource(R.string.info_screen_text),
                color = MaterialTheme.colors.surface)
            DescriptionText(text = stringResource(R.string.info_screen_description),
                color = MaterialTheme.colors.surface)
        }
}


@Preview(showBackground = true)
@Composable
fun DefaultInfoScreenPreview() {
    GumTreeAppTheme {
        InfoScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkInfoScreenPreview() {
    GumTreeAppTheme {
        InfoScreen()
    }
}