package com.example.jucrsampleapp.aboutcar.data.repository

import com.example.jucrsampleapp.aboutcar.data.model.CarInfoResponse
import com.example.jucrsampleapp.aboutcar.data.model.LocationRequest
import com.example.jucrsampleapp.aboutcar.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.aboutcar.data.model.StatisticResponse

interface AboutCarRepository {

    suspend fun getCarInfo(): CarInfoResponse

    suspend fun getStatistics(): List<StatisticResponse>

    suspend fun getNearbySupercharges(locationRequest: LocationRequest): List<NearbySuperchargeResponse>
}