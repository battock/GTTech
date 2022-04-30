package com.example.gumtreetechtest.ui.screens

import android.text.Html
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
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
    navController: NavController?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    )
        {
            HeaderText(text = "Info screen")
            DescriptionText(text = stringResource(R.string.info_screen_description))
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