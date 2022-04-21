package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun RowItemAtStart(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        content()
    }
}

@Composable
fun RowItemAtEnd(
    modifier: Modifier = Modifier,
    content: @Composable() () -> Unit) {
    Row(
        modifier = modifier
            .wrapContentSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        content()
    }
}
@Composable
fun RowItemAtStart(
    modifier: Modifier = Modifier,
    content: @Composable() () -> Unit) {
    Row(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        content()
    }
}

