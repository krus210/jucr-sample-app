package com.example.jucrsampleapp.aboutcar.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
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
import androidx.compose.ui.unit.dp
import com.example.jucrsampleapp.aboutcar.presentation.model.NearbySuperchargeModel

@Composable
fun NearbySuperchargeItem(item: NearbySuperchargeModel, onClick: (String?) -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onClick(item.deeplink) }
            .padding(start = 16.dp, end = 16.dp)
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