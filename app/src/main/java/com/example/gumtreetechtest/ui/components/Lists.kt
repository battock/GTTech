package com.example.gumtreetechtest.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items

@Composable
fun ScrollingList(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            HeaderText(item)
        }
    }
}