package com.example.jucrsampleapp.aboutcar.presentation.state

import com.example.jucrsampleapp.aboutcar.presentation.model.NearbySupercharge

sealed class NearbySuperchargesState {

    data class Success(
        val data: List<NearbySupercharge>
    ): NearbySuperchargesState()

    object Loading: NearbySuperchargesState()

    data class Error(
        val message: String?
    ): NearbySuperchargesState()
}
