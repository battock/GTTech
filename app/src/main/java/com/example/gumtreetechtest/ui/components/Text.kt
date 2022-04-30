package com.example.gumtreetechtest.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.gumtreetechtest.R


@Composable
fun HeaderText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.h5
    )
}
@Composable
fun SubHeaderText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.h6,
        fontSize = 22.sp
    )
}

@Composable
fun DescriptionText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier.wrapContentSize()
) {
    Text(
        modifier =Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun SmallDescriptionText(
    modifier: Modifier = Modifier,
    text: String,
    @StringRes txtRes: Int = R.string.app_name
) {
    Text(
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.body2
    )
}
