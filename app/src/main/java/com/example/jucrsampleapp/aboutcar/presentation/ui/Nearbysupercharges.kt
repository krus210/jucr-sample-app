package com.example.jucrsampleapp.aboutcar.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jucrsampleapp.R
import com.example.jucrsampleapp.aboutcar.presentation.model.NearbySupercharge
import com.example.jucrsampleapp.aboutcar.presentation.state.NearbySuperchargesState

@Composable
fun NearbySupercharges(state: NearbySuperchargesState, onClick: (String?) -> Unit) {
    when (state) {
        is NearbySuperchargesState.Success -> NearbySuperchargesSuccess(
            nearbySupercharges = state.data, onClick = onClick)
        NearbySuperchargesState.Loading -> NearbySuperchargesLoading()
        is NearbySuperchargesState.Error -> NearbySuperchargesError(state.message)
    }
}

@Composable
fun NearbySuperchargesSuccess(nearbySupercharges: List<NearbySupercharge>, onClick: (String?) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = nearbySupercharges,
            key = { nearbySupercharge -> nearbySupercharge.id }
        ) { item ->
            NearbySuperchargeItem(item, onClick)
        }
    }
}

@Composable
fun NearbySuperchargeItem(item: NearbySupercharge, onClick: (String?) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick(item.deeplink) }
        ,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.subtitle1
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = item.subtitle,
                    style = MaterialTheme.typography.subtitle2
                )
            }
            Column() {
                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 24.dp, height = 24.dp),
                    tint = colorResource(item.tint)
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = item.distance,
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
fun NearbySuperchargesLoading() {
    //TODO
}

@Composable
fun NearbySuperchargesError(message: String?) {
    //TODO
}