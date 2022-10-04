package com.example.jucrsampleapp.aboutcar.presentation.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jucrsampleapp.aboutcar.presentation.model.Statistic
import com.example.jucrsampleapp.aboutcar.presentation.state.StatisticsState

@Composable
fun Statistics(state: StatisticsState, onClick: (String?) -> Unit) {
    when (state) {
        is StatisticsState.Success -> StatisticSuccess(statistics = state.data, onClick)
        StatisticsState.Loading -> StatisticLoading()
        is StatisticsState.Error -> StatisticError(state.message)
    }
}

@Composable
fun StatisticSuccess(statistics: List<Statistic>, onClick: (String?) -> Unit) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = statistics,
            key = { statistic -> statistic.id }
        ) { item ->
            StatisticItem(item, onClick)
        }
    }
}

@Composable
fun StatisticItem(statistic: Statistic, onClick: (String?) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick(statistic.deeplink) }
        ,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 48.dp, top = 16.dp, bottom = 16.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .alpha(0.3f)
                        .background(colorResource(statistic.tint))
                )
                Icon(
                    painter = painterResource(statistic.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp),
                    tint = colorResource(statistic.tint)
                )
            }
            Text(
                text = statistic.title,
                modifier = Modifier.padding(top = 8.dp),
                style = MaterialTheme.typography.subtitle1
            )
            Text(
                text = statistic.subtitle,
                modifier = Modifier.padding(top = 4.dp),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}

@Composable
fun StatisticLoading() {
  //TODO
}

@Composable
fun StatisticError(message: String?) {
    //TODO
}