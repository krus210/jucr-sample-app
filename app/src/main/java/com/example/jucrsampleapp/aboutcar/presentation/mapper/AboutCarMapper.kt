package com.example.jucrsampleapp.aboutcar.presentation.mapper

import com.example.jucrsampleapp.R
import com.example.jucrsampleapp.aboutcar.data.model.CarInfoResponse
import com.example.jucrsampleapp.aboutcar.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.aboutcar.data.model.StatisticResponse
import com.example.jucrsampleapp.aboutcar.presentation.model.*
import com.example.jucrsampleapp.aboutcar.presentation.utils.ResourcesWrapper
import javax.inject.Inject

class AboutCarMapper
@Inject constructor(
    private val resourcesWrapper: ResourcesWrapper
){

    fun mapToCarInfo(response: CarInfoResponse): CarInfoModel {
        with (response) {
            return CarInfoModel(
                image = resourcesWrapper.getDrawableIdentifier(image) ?: R.drawable.hyandai_suv,
                background = resourcesWrapper.getColorIdentifier(background) ?: R.color.red,
                collapsingTitle = collapsingTitle,
                collapsingSubtitle = collapsingSubtitle,
                title = title,
                subtitle = subtitle,
                chargePercent = chargePercent,
                timeToEnd = CarInfoModel.TimeToEnd(
                    title = timeToEnd.title,
                    value = timeToEnd.value
                )
            )
        }
    }

    fun mapToStatistics(response: List<StatisticResponse>): StatisticsModel {
        return StatisticsModel(
            data = response.map {
                StatisticItemModel(
                    id = it.id,
                    icon = resourcesWrapper.getDrawableIdentifier(it.icon) ?: R.drawable.battery_charge_solid,
                    tint = resourcesWrapper.getColorIdentifier(it.tint) ?: R.color.green,
                    title = it.title,
                    subtitle = it.subtitle,
                    deeplink = it.deeplink
                )
            }
        )
    }

    fun mapToNearbySupercharges(response: List<NearbySuperchargeResponse>): List<NearbySuperchargeModel> {
        return response.map {
            NearbySuperchargeModel(
                id = it.id,
                title = it.title,
                subtitle = it.subtitle,
                distance = it.distance,
                icon = resourcesWrapper.getDrawableIdentifier(it.icon) ?: R.drawable.location_dot_solid,
                tint = resourcesWrapper.getColorIdentifier(it.tint) ?: R.color.grey,
                deeplink = it.deeplink
            )
        }
    }

    fun mapToStatisticsTile(): TitleModel {
        return TitleModel(
            id = 102,
            title = R.string.statistics_title
        )
    }

    fun mapToNearbySuperchargesTile(): TitleModel {
        return TitleModel(
            id = 103,
            title = R.string.nearby_supercharger_title,
            subtitle = R.string.nearby_supercharger_subtitle
        )
    }
}