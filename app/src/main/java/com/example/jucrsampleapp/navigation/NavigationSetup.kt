package com.example.jucrsampleapp.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jucrsampleapp.aboutcar.presentation.ui.AboutCarScreen

private const val NOT_IMPLEMENTED = "Not implemented"

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.AboutCar.route) {
        composable(BottomNavItem.AboutCar.route) {
            AboutCarScreen()
        }
        composable(BottomNavItem.Search.route) {
            SearchScreen()
        }
        composable(BottomNavItem.Maps.route) {
            MapsScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
fun SearchScreen() {
    Text(NOT_IMPLEMENTED)
}

@Composable
fun MapsScreen() {
    Text(NOT_IMPLEMENTED)
}

@Composable
fun ProfileScreen() {
    Text(NOT_IMPLEMENTED)
}