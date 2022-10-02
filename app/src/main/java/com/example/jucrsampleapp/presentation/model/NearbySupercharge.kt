package com.example.jucrsampleapp.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class NearbySupercharge(
    val id: Int,
    val title: String,
    val subtitle: String,
    val distance: String,
    @DrawableRes val icon: Int,
    @ColorRes val tint: Int,
    val deeplink: String?
)
