package com.example.jucrsampleapp.aboutcar.presentation.ui

import android.content.Context
import android.util.DisplayMetrics
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jucrsampleapp.aboutcar.presentation.model.*
import com.example.jucrsampleapp.aboutcar.presentation.state.AboutCarState
import com.example.jucrsampleapp.aboutcar.presentation.viewmodel.AboutCarViewModel
import kotlinx.coroutines.launch

@Composable
fun AboutCarScreen(viewModel: AboutCarViewModel = hiltViewModel()) {
    val state by viewModel.state
    val context = LocalContext.current

    when (state) {
        is AboutCarState.Success -> {
            AboutCarSuccess(
                (state as AboutCarState.Success).carInfo,
                (state as AboutCarState.Success).data,
                context
            ) {
                Toast.makeText(context, "Not implemented", Toast.LENGTH_LONG).show()
            }
        }
        AboutCarState.Loading -> AboutCarLoading()
        is AboutCarState.Error -> AboutCarError((state as AboutCarState.Error).errorMessage)
    }
}

@Composable
fun AboutCarSuccess(
    carInfoModel: CarInfoModel,
    data: List<ItemModel>,
    context: Context,
    onClick: (String?) -> Unit
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            CarInfo(
                carInfoModel,
                context,
                listState,
                onCollapseClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(1)
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .animateContentSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = listState
        ) {
            items(
                items = data,
                key = { itemModel -> itemModel.id }
            ) { item ->
                when (item) {
                    is TitleModel -> if (item.subtitle != null) NearbySuperChargesTitle(item.title, item.subtitle, onClick)
                    else StatisticTitle(item.title, onClick)
                    is StatisticsModel -> Statistics(item.data, onClick)
                    is NearbySuperchargeModel -> NearbySuperchargeItem(item, onClick)
                }
            }
        }
    }
}

@Composable
fun AboutCarLoading() {
    //TODO
}

@Composable
fun AboutCarError(message: String?) {
    //TODO
}

