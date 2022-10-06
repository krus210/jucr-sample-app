package com.example.jucrsampleapp.aboutcar.presentation.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jucrsampleapp.R

@Composable
fun StatisticTitle(
    @StringRes titleRes: Int,
    onClick: (String?) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(titleRes),
            style = MaterialTheme.typography.h6
        )
        IconButton(onClick = { onClick(null) }) {
            Icon(
                painter = painterResource(R.drawable.ellipsis_solid),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 24.dp, height = 24.dp),
                tint = MaterialTheme.colors.onSecondary
            )
        }
    }
}