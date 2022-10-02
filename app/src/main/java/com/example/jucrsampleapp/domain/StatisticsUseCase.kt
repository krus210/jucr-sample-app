package com.example.jucrsampleapp.domain

import com.example.jucrsampleapp.data.model.StatisticResponse
import com.example.jucrsampleapp.data.repository.AboutCarRepository
import javax.inject.Inject

class StatisticsUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(): List<StatisticResponse> {
        return repository.getStatistics()
    }
}