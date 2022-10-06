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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class AboutCarViewModel
@Inject constructor(
    private val carInfoUseCase: CarInfoUseCase,
    private val statisticsUseCase: StatisticsUseCase,
    private val nearbySuperchargesUseCase: NearbySuperchargesUseCase,
    private val mapper: AboutCarMapper
): ViewModel() {

    private val _state = mutableStateOf<AboutCarState>(
        value = AboutCarState.Loading
    )
    val state: State<AboutCarState> = _state

    init {
        loadData()
    }


    fun loadData() {
        viewModelScope.launch {
            _state.value = AboutCarState.Loading
            supervisorScope {
                val carInfo = async {
                    mapper.mapToCarInfo(carInfoUseCase.get())
                }
                val statistics = async {
                    mapper.mapToStatistics(statisticsUseCase.get())
                }
                val nearbyCharges = async {
                    mapper.mapToNearbySupercharges(nearbySuperchargesUseCase.get())
                }
                try {
                    val data = mutableListOf(
                        mapper.mapToStatisticsTile(),
                        statistics.await(),
                        mapper.mapToNearbySuperchargesTile(),
                    )
                    data.addAll(nearbyCharges.await())
                    _state.value = AboutCarState.Success(
                        carInfo.await(),
                        data
                    )
                } catch (ex: Throwable) {
                    _state.value = AboutCarState.Error(ex.message)
                }
            }
        }
    }
}