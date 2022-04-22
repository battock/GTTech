package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.gumtreetechtest.R

@Composable
fun StandardButton(modifier: Modifier = Modifier, text: String = "", onClick: () -> Unit = {}) {
    Button(
        modifier = Modifier
            .border(
                dimensionResource(R.dimen.standard_border_thickness),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.standard_corner_radius)),
                color = MaterialTheme.colors.primary
            )
            .shadow(2.dp)
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.standard_component_height))
            .background(color = Color.White, shape = CircleShape),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = dimensionResource(id = R.dimen.large_padding))
        ) {
            DescriptionText(text = text)
        }
    }
}