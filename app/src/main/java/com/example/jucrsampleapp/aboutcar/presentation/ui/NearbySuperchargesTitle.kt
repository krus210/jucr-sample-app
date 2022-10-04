package com.example.jucrsampleapp.aboutcar.presentation.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.jucrsampleapp.R

@Composable
fun NearbySuperChargesTitle(
    @StringRes titleRes: Int,
    onClick: () -> Unit
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
        TextButton(onClick = onClick) {
            Text(
                text = stringResource(R.string.nearby_supercharger_subtitle),
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}