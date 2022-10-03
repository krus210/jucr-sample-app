package com.example.jucrsampleapp.aboutcar.presentation.state

import androidx.annotation.StringRes
import com.example.jucrsampleapp.R

data class AboutCarState(
    val carInfoState: CarInfoState = CarInfoState.Loading(isCollapsed = false),
    @StringRes val statisticTitle: Int = R.string.statistics_title,
    val statisticsState: StatisticsState = StatisticsState.Loading,
    @StringRes val nearbySuperchargesTitle: Int = R.string.nearby_supercharger_title,
    @StringRes val nearbySuperchargesSubtitle: Int = R.string.nearby_supercharger_subtitle,
    val nearbySuperchargesState: NearbySuperchargesState = NearbySuperchargesState.Loading
)

