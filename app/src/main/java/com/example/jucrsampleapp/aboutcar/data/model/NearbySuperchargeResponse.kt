package com.example.jucrsampleapp.aboutcar.data.model

data class NearbySuperchargeResponse(
    val id: Int,
    val title: String,
    val subtitle: String,
    val distance: String,
    val icon: String,
    val tint: String,
    val deeplink: String?
)
