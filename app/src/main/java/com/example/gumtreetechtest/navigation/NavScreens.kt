package com.example.gumtreetechtest.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gumtreetechtest.R

sealed class Screen(val route: String,
                    @StringRes val resourceId: Int,
                    val icon: ImageVector = Icons.Default.Lock,
                    @StringRes val contentDescription: Int = 0) {

    object SearchScreen : Screen("search", R.string.search)
    object ResultsScreen : Screen("results", R.string.results)
}