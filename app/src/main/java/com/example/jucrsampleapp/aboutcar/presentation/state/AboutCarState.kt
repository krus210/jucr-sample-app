package com.example.jucrsampleapp.aboutcar.presentation.state

import com.example.jucrsampleapp.aboutcar.presentation.model.CarInfoModel
import com.example.jucrsampleapp.aboutcar.presentation.model.ItemModel

sealed class AboutCarState {

    data class Success(
        val carInfo: CarInfoModel,
        val data: List<ItemModel>
    ) : AboutCarState()

    object Loading : AboutCarState()

    data class Error(val errorMessage: String?) : AboutCarState()
}
