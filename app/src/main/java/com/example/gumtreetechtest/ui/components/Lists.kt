package com.example.gumtreetechtest.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.ui.themes.card

@Composable
fun ScrollingList(items: List<Car>) = if (items.size > 0) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            4.dp,
            Alignment.CenterVertically
        ),
        modifier = Modifier
            .fillMaxSize()
            .semantics { contentDescription = RESULTS_SECTION_DESCRIPTION  }
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
fun CarListItem(car: Car,
                modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .background(Color.Gray)
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding)
            )
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.large_component_height)),
    ) {
        Column {
            HeaderText(
                text = car.title
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))
            SubHeaderText(
                text = car.price
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.small_padding)))
            DescriptionText(
                text = "${car.make}   ${car.model}   ${car.year} "
            )
        }
    }
}

const val RESULTS_SECTION_DESCRIPTION = "results_section_description"