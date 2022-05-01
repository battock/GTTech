package com.example.gumtreetechtest.ui.screens


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.components.*
import com.example.gumtreetechtest.ui.themes.GumTreeAppTheme
import com.example.gumtreetechtest.ui.viewmodels.MainViewModel

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
            SearchTextField(
                modifier = Modifier.semantics {
                    contentDescription = MAKE_INPUT_FIELD_DESCRIPTION
                },
                label = stringResource(R.string.make_input_txt),
                onTxtChange = { viewModel.setMake(it) },
                selectedItem = viewModel.selectedMake
            )
            SearchTextField(
                modifier = Modifier.semantics {
                    contentDescription = MODEL_INPUT_FIELD_DESCRIPTION
                },
                label = stringResource(R.string.model_input_txt),
                onTxtChange = { viewModel.setModel(it) },
                selectedItem = viewModel.selectedModel,
            )
            SearchTextField(
                modifier = Modifier.semantics {
                    contentDescription = YEAR_INPUT_FIELD_DESCRIPTION
                },
                label = stringResource(R.string.year_input_txt),
                onTxtChange = { viewModel.setYear(it) },
                selectedItem = viewModel.selectedYear,
            )
            StandardButton(
                modifier = Modifier
                    .semantics { contentDescription = UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION },
                stringResource(R.string.update_results_cta),
                onClick = {
                    viewModel.upDateResults()
                }
            )
        }
    }
}

@Preview
@Composable
fun showSearchScreen(){
    GumTreeAppTheme {
        SearchSection()
    }
}

const val UPDATE_SEARCH_RESULTS_BUTTON_DESCRIPTION = "update_results_button"
const val MAKE_INPUT_FIELD_DESCRIPTION = "input_field_make_description"
const val MODEL_INPUT_FIELD_DESCRIPTION = "input_field_model_description"
const val YEAR_INPUT_FIELD_DESCRIPTION = "input_field_year_description"


