package com.example.gumtreetechtest.ui.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.gumtreetechtest.R
import com.example.gumtreetechtest.ui.models.Car
import com.example.gumtreetechtest.ui.themes.card

@Composable
fun ScrollingList(items: List<Car>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(
            4.dp,
            Alignment.CenterVertically
        ),
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items) { item ->
            CarListItem(item)
        }
    }
}

@Composable
fun CarListItem(car: Car) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .border(
                dimensionResource(id = R.dimen.standard_border_thickness),
                card,
                RoundedCornerShape(6.dp)
            )
            .padding(
                horizontal = dimensionResource(id = R.dimen.medium_padding)
            )
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.large_component_height)),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SubHeaderText(
            text = car.title
        )
        SubHeaderText(
            text = car.price
        )
    }

}