package com.example.jucrsampleapp.domain

import com.example.jucrsampleapp.data.model.CarInfoResponse
import com.example.jucrsampleapp.data.repository.AboutCarRepository
import javax.inject.Inject

class CarInfoUseCase
@Inject constructor(
    private val repository: AboutCarRepository
){

    suspend fun get(): CarInfoResponse {
        return repository.getCarInfo()
    }
}