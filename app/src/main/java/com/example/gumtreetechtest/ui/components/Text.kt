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
    color:Color = MaterialTheme.colors.primaryVariant
) {
    Text(
        modifier = modifier.wrapContentSize(),
        text = text,
        color = color,
        style = MaterialTheme.typography.h5
    )
}
@Composable
fun SubHeaderText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier,
    color:Color = MaterialTheme.colors.background
) {
    Text(
        modifier = modifier.wrapContentSize(),
        text = text,
        color = color,
        style = MaterialTheme.typography.h6,
        fontSize = 18.sp
    )
}
@Composable
fun ErrorText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier
) {
    Text(
        modifier =modifier.wrapContentSize(),
        text = text,
        color = Color.Red,
        style = MaterialTheme.typography.body2
    )
}
@Composable
fun DescriptionText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier,
    color:Color = MaterialTheme.colors.background
) {
    Text(
        modifier =modifier.wrapContentSize(),
        text = text,
        color = color,
        style = MaterialTheme.typography.body1
    )
}