package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.ui.themes.MotorsGreyLight

@Composable
fun ScrollingList(items: List<Car>) = if (items.size > 0) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.small_padding),
            Alignment.CenterVertically
        ),
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = RESULTS_SECTION_DESCRIPTION }
    ) {
        items(items) { item ->
            CarListItem(item)
        }
    }
} else {
    Column(
        Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.medium_padding)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DescriptionText(text = stringResource(R.string.no_data_message))
    }
}

@Composable
fun CarListItem(
    car: Car,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.standard_corner_radius)),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.large_component_height))
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.medium_padding),
                    vertical = dimensionResource(id = R.dimen.small_padding)
                )
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))

            HeaderText(
                text = car.title,
                color = MotorsGreyLight
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.medium_padding)))
            SubHeaderText(
                text = car.price,
                color = MotorsGreyLight
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))
            DescriptionText(
                text = "${car.make}   ${car.model}   ${car.year} ",
                color = MotorsGreyLight
            )
        }
    }
}

const val RESULTS_SECTION_DESCRIPTION = "results_section_description"