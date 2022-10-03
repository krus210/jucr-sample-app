package com.example.jucrsampleapp.aboutcar.presentation.state

import com.example.jucrsampleapp.aboutcar.presentation.model.Statistic

sealed class StatisticsState {

    data class Success(
        val data: List<Statistic>
    ): StatisticsState()

    object Loading: StatisticsState()

    data class Error(
        val message: String?
    ): StatisticsState()
}
