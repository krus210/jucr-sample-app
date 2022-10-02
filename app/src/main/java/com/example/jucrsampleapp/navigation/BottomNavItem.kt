package com.example.jucrsampleapp.navigation

import androidx.annotation.DrawableRes
import com.example.jucrsampleapp.R

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int
) {

    object AboutCar: BottomNavItem(
        route = Screen.AboutCar.route,
        icon = R.drawable.car_solid
    )

    object Search: BottomNavItem(
        route = Screen.Search.route,
        icon = R.drawable.search_solid
    )

    object Maps: BottomNavItem(
        route = Screen.Maps.route,
        icon = R.drawable.map_solid
    )

    object Profile: BottomNavItem(
        route = Screen.Profile.route,
        icon = R.drawable.user_solid
    )
}
