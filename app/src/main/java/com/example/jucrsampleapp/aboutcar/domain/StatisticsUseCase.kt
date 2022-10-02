package com.example.jucrsampleapp.aboutcar.domain

import com.example.jucrsampleapp.aboutcar.data.model.StatisticResponse
import com.example.jucrsampleapp.aboutcar.data.repository.AboutCarRepository
import javax.inject.Inject

class StatisticsUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(): List<StatisticResponse> {
        return repository.getStatistics()
    }
}