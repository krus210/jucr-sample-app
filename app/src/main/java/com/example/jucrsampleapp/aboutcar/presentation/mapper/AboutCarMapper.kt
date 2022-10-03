package com.example.jucrsampleapp.aboutcar.presentation.mapper

import com.example.jucrsampleapp.R
import com.example.jucrsampleapp.aboutcar.data.model.CarInfoResponse
import com.example.jucrsampleapp.aboutcar.data.model.NearbySuperchargeResponse
import com.example.jucrsampleapp.aboutcar.data.model.StatisticResponse
import com.example.jucrsampleapp.aboutcar.presentation.model.CarInfo
import com.example.jucrsampleapp.aboutcar.presentation.model.NearbySupercharge
import com.example.jucrsampleapp.aboutcar.presentation.model.Statistic
import com.example.jucrsampleapp.aboutcar.presentation.utils.ResourcesWrapper
import javax.inject.Inject

class AboutCarMapper
@Inject constructor(
    private val resourcesWrapper: ResourcesWrapper
){

    fun mapToCarInfo(response: CarInfoResponse): CarInfo {
        with (response) {
            return CarInfo(
                image = resourcesWrapper.getDrawableIdentifier(image) ?: R.drawable.hyandai_suv,
                background = resourcesWrapper.getColorIdentifier(background) ?: R.color.red,
                collapsingTitle = collapsingTitle,
                collapsingSubtitle = collapsingSubtitle,
                title = title,
                subtitle = subtitle,
                chargePercent = chargePercent,
                timeToEnd = CarInfo.TimeToEnd(
                    title = timeToEnd.title,
                    value = timeToEnd.value
                )
            )
        }
    }

    fun mapToStatistic(response: StatisticResponse): Statistic {
        with (response) {
            return Statistic(
                id = id,
                icon = resourcesWrapper.getDrawableIdentifier(icon) ?: R.drawable.battery_charge_solid,
                tint = resourcesWrapper.getColorIdentifier(tint) ?: R.color.green,
                title = title,
                subtitle = subtitle,
                deeplink = deeplink
            )
        }
    }

    fun mapToNearbySupercharge(response: NearbySuperchargeResponse): NearbySupercharge {
        with (response) {
            return NearbySupercharge(
                id = id,
                title = title,
                subtitle = subtitle,
                distance = distance,
                icon = resourcesWrapper.getDrawableIdentifier(icon) ?: R.drawable.location_dot_solid,
                tint = resourcesWrapper.getColorIdentifier(tint) ?: R.color.grey,
                deeplink = deeplink
            )
        }
    }
}