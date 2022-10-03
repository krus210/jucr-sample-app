package com.example.jucrsampleapp.aboutcar.presentation.state

import com.example.jucrsampleapp.aboutcar.presentation.model.CarInfo

sealed class CarInfoState(
    open val isCollapsed: Boolean
) {

    data class Success(
        val data: CarInfo,
        override val isCollapsed: Boolean
    ): CarInfoState(isCollapsed)

    data class Loading(
        override val isCollapsed: Boolean
    ): CarInfoState(isCollapsed)

    data class Error(
        val message: String?,
        override val isCollapsed: Boolean
    ): CarInfoState(isCollapsed)
}
