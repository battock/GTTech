package com.example.gumtreetechtest.ui.screens


import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.*
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel
import java.lang.NumberFormatException

const val SEARCH_SECTION_LOGGING_TAG = "Search Section screen"

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
                color = Color.LightGray,
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
                selectedItem = viewModel.selectedMake
            )
            SearchTextField(
                "Model",
                onTxtChange = { viewModel.setModel(it) },
                selectedItem = viewModel.selectedModel,
            )
            SearchTextField(
                "Year",
                onTxtChange = { viewModel.setYear(it) },
                selectedItem = viewModel.selectedYear,
            )
            StandardButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                "Update results",
                onClick = {
                    viewModel.upDateResults()
                }
            )
        }
    }
}


