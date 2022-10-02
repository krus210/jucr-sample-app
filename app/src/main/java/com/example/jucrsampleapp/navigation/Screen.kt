package com.example.jucrsampleapp.navigation

sealed class Screen(val route: String) {
    object AboutCar : Screen("about_car_screen")
    object Search : Screen("search_screen")
    object Maps : Screen("maps_screen")
    object Profile : Screen("profiles_screen")
}
