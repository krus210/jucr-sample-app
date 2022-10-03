package com.example.jucrsampleapp.aboutcar.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jucrsampleapp.aboutcar.domain.CarInfoUseCase
import com.example.jucrsampleapp.aboutcar.domain.NearbySuperchargesUseCase
import com.example.jucrsampleapp.aboutcar.domain.StatisticsUseCase
import com.example.jucrsampleapp.aboutcar.presentation.mapper.AboutCarMapper
import com.example.jucrsampleapp.aboutcar.presentation.state.AboutCarState
import com.example.jucrsampleapp.aboutcar.presentation.state.CarInfoState
import com.example.jucrsampleapp.aboutcar.presentation.state.NearbySuperchargesState
import com.example.jucrsampleapp.aboutcar.presentation.state.StatisticsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutCarViewModel
@Inject constructor(
    private val carInfoUseCase: CarInfoUseCase,
    private val statisticsUseCase: StatisticsUseCase,
    private val nearbySuperchargesUseCase: NearbySuperchargesUseCase,
    private val mapper: AboutCarMapper
): ViewModel() {

    private val _state = mutableStateOf(
        value = AboutCarState()
    )
    val state: State<AboutCarState> = _state

    init {
        loadCarInfo(isCollapsed = false)
        loadStatistics()
        loadNearbySupercharges()
    }

    fun loadCarInfo(isCollapsed: Boolean) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                carInfoState = CarInfoState.Loading(isCollapsed)
            )
            try {
                val carInfo = mapper.mapToCarInfo(carInfoUseCase.get())
                _state.value = _state.value.copy(
                    carInfoState = CarInfoState.Success(
                        data = carInfo,
                        isCollapsed = isCollapsed
                    )
                )
            } catch (e: Throwable) {
                _state.value = _state.value.copy(
                    carInfoState = CarInfoState.Error(
                        e.message,
                        isCollapsed
                    )
                )
            }
        }
    }

    fun loadStatistics() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                statisticsState = StatisticsState.Loading
            )
            try {
                val statistics = statisticsUseCase.get().map { mapper.mapToStatistic(it) }
                _state.value = _state.value.copy(
                    statisticsState = StatisticsState.Success(
                        data = statistics
                    )
                )
            } catch (e: Throwable) {
                _state.value = _state.value.copy(
                    statisticsState = StatisticsState.Error(e.message)
                )
            }
        }
    }

    fun loadNearbySupercharges() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                nearbySuperchargesState = NearbySuperchargesState.Loading
            )
            try {
                val nearbySuperCharges = nearbySuperchargesUseCase.get().map { mapper.mapToNearbySupercharge(it) }
                _state.value = _state.value.copy(
                    nearbySuperchargesState = NearbySuperchargesState.Success(
                        data = nearbySuperCharges
                    )
                )
            } catch (e: Throwable) {
                _state.value = _state.value.copy(
                    nearbySuperchargesState = NearbySuperchargesState.Error(e.message)
                )
            }
        }
    }
}