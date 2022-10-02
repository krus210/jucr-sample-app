package com.example.jucrsampleapp.aboutcar.domain

import com.example.jucrsampleapp.aboutcar.data.model.CarInfoResponse
import com.example.jucrsampleapp.aboutcar.data.repository.AboutCarRepository
import javax.inject.Inject

class CarInfoUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(): CarInfoResponse {
        return repository.getCarInfo()
    }
}