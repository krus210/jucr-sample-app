package com.example.jucrsampleapp.domain

import com.example.jucrsampleapp.data.model.LocationRequest
import com.example.jucrsampleapp.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.data.repository.AboutCarRepository
import javax.inject.Inject

class NearbySuperchargesUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(locationRequest: LocationRequest = LocationRequest()): List<NearbySuperchargeResponse> {
        return repository.getNearbySupercharges(locationRequest)
    }
}