package com.example.jucrsampleapp.aboutcar.domain

import com.example.jucrsampleapp.aboutcar.data.model.LocationRequest
import com.example.jucrsampleapp.aboutcar.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.aboutcar.data.repository.AboutCarRepository
import javax.inject.Inject

class NearbySuperchargesUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(locationRequest: LocationRequest = LocationRequest()): List<NearbySuperchargeResponse> {
        return repository.getNearbySupercharges(locationRequest)
    }
}