package com.example.jucrsampleapp.data.repository

import com.example.jucrsampleapp.data.model.CarInfoResponse
import com.example.jucrsampleapp.data.model.LocationRequest
import com.example.jucrsampleapp.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.data.model.StatisticResponse

interface AboutCarRepository {

    suspend fun getCarInfo(): CarInfoResponse

    suspend fun getStatistics(): List<StatisticResponse>

    suspend fun getNearbySupercharges(locationRequest: LocationRequest): List<NearbySuperchargeResponse>
}