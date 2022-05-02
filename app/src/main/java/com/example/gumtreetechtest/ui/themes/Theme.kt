package com.example.gumtreetechtest.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val GumTreeDarkColorPalette = darkColors(
    primary = MotorsGreen,
    primaryVariant = MotorsOtherGreen,
    secondary = MotorsGreen,
    background = MotorsDarkGrey,
    surface = MotorsOrange,
    onSurface = MotorsGrey,
    error = Color.Red
)

private val GumTreeLightColorPalette = lightColors(
    primary = MotorsOtherGreen,
    primaryVariant = MotorsBlue,
    secondary = MotorsOrange,
    background = MotorsWhite,
    surface = MotorsDarkGrey,
    onSurface = MotorsGrey,
    error = Color.Red
)
@Composable
fun GumTreeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        GumTreeDarkColorPalette
    } else {
        GumTreeLightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}