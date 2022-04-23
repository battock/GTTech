package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.gumtreetechtest.R

@Composable
fun ScrollingList(items: List<String>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.standard_padding))
    ) {
        items(items) { item ->
            HeaderText(item)
        }
    }
}

