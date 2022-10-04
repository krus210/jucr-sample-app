package com.example.jucrsampleapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = FirstMainColor,
    primaryVariant = SecondMainColor,
    secondary = AdditionalColor
)

private val LightColorPalette = lightColors(
    primary = FirstMainColor,
    primaryVariant = SecondMainColor,
    secondary = AdditionalColor,

    background = Color.White,
    surface = LightGrayColor,
    onPrimary = Color.White,
    onSecondary = Color.LightGray,
    onBackground = Color.Black,
    onSurface = Color.Gray
)

@Composable
fun JUCRSampleAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}