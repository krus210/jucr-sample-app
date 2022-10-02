package com.example.jucrsampleapp.data.model

data class CarInfoResponse(
    val image: String,
    val background: String,
    val status: StatusDto,
    val collapsingTitle: String,
    val collapsingSubtitle: String,
    val title: String,
    val subtitle: String,
    val chargePercent: Int,
    val timeToEnd: TimeToEndDto
) {

    enum class StatusDto {
        CHARGING
    }

    data class TimeToEndDto(
        val title: String,
        val value: String
    )
}
