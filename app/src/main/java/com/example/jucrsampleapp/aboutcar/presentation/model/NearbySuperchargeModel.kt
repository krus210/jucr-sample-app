package com.example.jucrsampleapp.aboutcar.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class NearbySuperchargeModel(
    override val id: Int,
    val title: String,
    val subtitle: String,
    val distance: String,
    @DrawableRes val icon: Int,
    @ColorRes val tint: Int,
    val deeplink: String?
): ItemModel(id)
