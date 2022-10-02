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

    fun CarInfoResponse.mapToCarInfo(): CarInfo {
        return CarInfo(
            image = resourcesWrapper.getDrawableIdentifier(this.image) ?: R.drawable.hyandai_suv,
            background = resourcesWrapper.getColorIdentifier(this.background) ?: R.color.red,
            collapsingTitle = this.collapsingTitle,
            collapsingSubtitle = this.collapsingSubtitle,
            title = this.title,
            subtitle = this.subtitle,
            chargePercent = this.chargePercent,
            timeToEnd = CarInfo.TimeToEnd(
                title = this.timeToEnd.title,
                value = this.timeToEnd.value
            )
        )
    }

    fun StatisticResponse.mapToStatistic(): Statistic {
        return Statistic(
            id = this.id,
            icon = resourcesWrapper.getDrawableIdentifier(this.icon) ?: R.drawable.battery_charge_solid,
            tint = resourcesWrapper.getColorIdentifier(this.tint) ?: R.color.green,
            title = this.title,
            subtitle = this.subtitle,
            deeplink = this.deeplink
        )
    }

    fun NearbySuperchargeResponse.mapToNearbySupercharge(): NearbySupercharge {
        return NearbySupercharge(
            id = this.id,
            title = this.title,
            subtitle = this.subtitle,
            distance = this.distance,
            icon = resourcesWrapper.getDrawableIdentifier(this.icon) ?: R.drawable.location_dot_solid,
            tint = resourcesWrapper.getColorIdentifier(this.tint) ?: R.color.grey,
            deeplink = this.deeplink
        )
    }
}