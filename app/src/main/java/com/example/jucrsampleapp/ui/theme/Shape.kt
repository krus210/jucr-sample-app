package com.example.jucrsampleapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(
        topStart = 32.dp,
        topEnd = 32.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    ),
)

val roundedBottomShape = RoundedCornerShape(
    topStart = 0.dp,
    topEnd = 0.dp,
    bottomStart = 40.dp,
    bottomEnd = 40.dp
)

val roundedTopStartShape = RoundedCornerShape(
    topStart = 24.dp,
    topEnd = 4.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)

val roundedTopEndShape = RoundedCornerShape(
    topStart = 4.dp,
    topEnd = 24.dp,
    bottomStart = 0.dp,
    bottomEnd = 0.dp
)