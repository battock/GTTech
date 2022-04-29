package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.*
import com.example.gumtreetechtest.ui.themes.Purple200
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

@Composable
fun SearchSection(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    Box(
        modifier = modifier
            .wrapContentSize()

            .border(
                2.dp,
                color = Purple200,
                RectangleShape
            )
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(dimensionResource(id = R.dimen.standard_padding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        )
        {

            HeaderText(text = "Motors.co.uk")
            SearchTextField(
                "Make",
                onTxtChange = { viewModel.setMake(it) },
                listItems = viewModel.availableMakes
            )
            SearchTextField(
                "Model",
                onTxtChange = { viewModel.setModel(it) },
                listItems = viewModel.availableModels

            )
            SearchTextField(
                "Year",
                onTxtChange = { viewModel.setYear(2022) },
                listItems = viewModel.availableYears

            )
            StandardButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                "Update results",
                onClick = {viewModel.upDateResults()}
            )
        }
    }
}
