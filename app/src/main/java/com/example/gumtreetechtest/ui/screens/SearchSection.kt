package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.DescriptionText
import com.example.gumtreetechtest.ui.components.HeaderText
import com.example.gumtreetechtest.ui.components.ScrollingList
import com.example.gumtreetechtest.ui.components.StandardButton
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.themes.Purple200
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    Box(modifier = modifier
        .wrapContentHeight()
        .fillMaxWidth()
        .border(
            2.dp,
            color = Purple200,
            RectangleShape
        )
    ){
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.large_padding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {

            HeaderText(text = "Search section....")
            DescriptionText(text = "Search by make....")
            DescriptionText(text = "Search by model....")
            DescriptionText(text = "Search by year....")
            StandardButton(modifier = Modifier
                .fillMaxWidth(),
                "Search...")
        }
    }
}
