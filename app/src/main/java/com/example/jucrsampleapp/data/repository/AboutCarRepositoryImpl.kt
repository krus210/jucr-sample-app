package com.example.jucrsampleapp.data.repository

import com.example.jucrsampleapp.data.model.CarInfoResponse
import com.example.jucrsampleapp.data.model.LocationRequest
import com.example.jucrsampleapp.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.data.model.StatisticResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AboutCarRepositoryImpl
@Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcher
): AboutCarRepository {

    override suspend fun getCarInfo(): CarInfoResponse {
        return withContext(coroutineDispatcher) {
            delay(1000)
            getMockCarInfoResponse()
        }
    }

    override suspend fun getStatistics(): List<StatisticResponse> {
        return withContext(coroutineDispatcher) {
            delay(1500)
            getMockStatistics()
        }
    }

    override suspend fun getNearbySupercharges(locationRequest: LocationRequest): List<NearbySuperchargeResponse> {
        return withContext(coroutineDispatcher) {
            delay(2000)
            getMockNearbySuperCharges()
        }
    }

    private fun getMockCarInfoResponse(): CarInfoResponse {
        return CarInfoResponse(
            image = "hyandai_suv",
            background = "red",
            status = CarInfoResponse.StatusDto.CHARGING,
            collapsingTitle = "Good morning, Billy",
            collapsingSubtitle = "Charging your car...",
            title = "Tesla Model X",
            subtitle = "Charging",
            chargePercent = 58,
            timeToEnd = CarInfoResponse.TimeToEndDto(
                title = "TIME TO END OF CHARGE:",
                value = "49 MIN"
            )
        )
    }

    private fun getMockStatistics(): List<StatisticResponse> {
        return listOf(
            StatisticResponse(
                id = 1,
                icon = "voltage_solid",
                tint = "red",
                title = "240 Volt",
                subtitle = "Voltage",
                deeplink = null
            ),
            StatisticResponse(
                id = 2,
                icon = "battery_charge_solid",
                tint = "green",
                title = "540 km",
                subtitle = "Remaining charge",
                deeplink = null
            ),
            StatisticResponse(
                id = 3,
                icon = "charging_station_solid",
                tint = "yellow",
                title = "20 MIN",
                subtitle = "Fast charge",
                deeplink = null
            )
        )
    }

    private fun getMockNearbySuperCharges(): List<NearbySuperchargeResponse> {
        return listOf(
            NearbySuperchargeResponse(
                id = 1,
                title = "Ranchview Dr.Richardson",
                subtitle = "4/10 available",
                distance = "1.2 km",
                icon = "location_dot_solid",
                tint = "gray",
                deeplink = null
            ),
            NearbySuperchargeResponse(
                id = 2,
                title = "Thornridge Cir. Shiloh",
                subtitle = "5/10 available",
                distance = "2.6 km",
                icon = "location_dot_solid",
                tint = "gray",
                deeplink = null
            ),
            NearbySuperchargeResponse(
                id = 3,
                title = "Elgin St. Celina",
                subtitle = "8/10 available",
                distance = "4.3 km",
                icon = "location_dot_solid",
                tint = "gray",
                deeplink = null
            ),
            NearbySuperchargeResponse(
                id = 4,
                title = "Westheimer Rd. Santa Ana",
                subtitle = "3/10 available",
                distance = "5.4 km",
                icon = "location_dot_solid",
                tint = "gray",
                deeplink = null
            ),
        )
    }
}