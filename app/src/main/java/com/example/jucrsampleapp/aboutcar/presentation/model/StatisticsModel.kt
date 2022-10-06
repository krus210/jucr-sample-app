package com.example.jucrsampleapp.aboutcar.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

data class StatisticsModel(
    val data: List<StatisticItemModel>
): ItemModel(id = 101)

data class StatisticItemModel(
    val id: Int,
    @DrawableRes val icon: Int,
    @ColorRes val tint: Int,
    val title: String,
    val subtitle: String,
    val deeplink: String?
)
