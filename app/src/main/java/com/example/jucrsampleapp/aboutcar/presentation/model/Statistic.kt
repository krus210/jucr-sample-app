package com.example.jucrsampleapp.aboutcar.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class Statistic(
    val id: Int,
    @DrawableRes val icon: Int,
    @ColorRes val tint: Int,
    val title: String,
    val subtitle: String,
    val deeplink: String?
)
