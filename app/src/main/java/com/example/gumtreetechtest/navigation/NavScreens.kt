package com.example.gumtreetechtest.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gumtreetechtest.R

sealed class Screen(val route: String,
                    @StringRes val resourceId: Int,
                    val icon: ImageVector = Icons.Default.Home,
                    @StringRes val contentDescription: Int = 0) {

    object MainScreen : Screen("main", R.string.main_screen,icon= Icons.Default.Home)
    object InfoScreen : Screen("infoScreen", R.string.info_screen,icon = Icons.Default.Info)

}