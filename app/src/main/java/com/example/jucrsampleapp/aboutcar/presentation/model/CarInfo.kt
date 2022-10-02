package com.example.jucrsampleapp.aboutcar.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class CarInfo(
    @DrawableRes val image: Int,
    @ColorRes val background: Int,
    val collapsingTitle: String,
    val collapsingSubtitle: String,
    val title: String,
    val subtitle: String,
    val chargePercent: Int,
    val timeToEnd: TimeToEnd
) {

    data class TimeToEnd(
        val title: String,
        val value: String
    )
}
