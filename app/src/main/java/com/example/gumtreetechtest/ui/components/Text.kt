package com.example.gumtreetechtest.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.gumtreetechtest.R
import java.lang.reflect.Modifier


@Composable
fun HeaderText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier()
) {
    Text(
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        text = text,
        fontSize = 18.sp
    )
}

@Composable
fun SubHeaderText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier(),
) {
    Text(
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.h5
    )
}

@Composable
fun DescriptionText(
    text: String,
    @StringRes txtRes: Int = R.string.app_name,
    modifier: Modifier = Modifier()
) {
    Text(
        modifier = androidx.compose.ui.Modifier.wrapContentSize(),
        text = text,
        color = Color.White,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun SmallDescriptionText(
    modifier: Modifier = Modifier(),
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
