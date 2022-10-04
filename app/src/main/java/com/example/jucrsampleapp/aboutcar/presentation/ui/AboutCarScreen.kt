package com.example.jucrsampleapp.aboutcar.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jucrsampleapp.aboutcar.presentation.ui.carinfo.CarInfo
import com.example.jucrsampleapp.aboutcar.presentation.viewmodel.AboutCarViewModel

@Composable
fun AboutCarScreen(viewModel: AboutCarViewModel = hiltViewModel()) {
    val state by viewModel.state
    val context = LocalContext.current

    Column {
        CarInfo(state.carInfoState) {
            viewModel.onCollapseClick()
        }
        StatisticTitle(titleRes = state.statisticTitle) {
            Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG).show()
        }
        Statistics(state.statisticsState) {
            Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG).show()
        }
        NearbySuperChargesTitle(state.nearbySuperchargesTitle) {
            Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG).show()
        }
        NearbySupercharges(state.nearbySuperchargesState) {
            Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG).show()
        }
     }
}