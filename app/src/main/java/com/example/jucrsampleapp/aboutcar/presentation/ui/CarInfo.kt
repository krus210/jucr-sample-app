package com.example.jucrsampleapp.aboutcar.presentation.ui

import android.content.Context
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import com.example.jucrsampleapp.R
import com.example.jucrsampleapp.aboutcar.presentation.model.CarInfoModel
import com.example.jucrsampleapp.ui.theme.roundedBottomShape
import com.example.jucrsampleapp.ui.theme.roundedTopEndShape
import com.example.jucrsampleapp.ui.theme.roundedTopStartShape

@OptIn(ExperimentalMotionApi::class)
@Composable
fun CarInfo(
    data: CarInfoModel,
    context: Context,
    scrollState: LazyListState,
    onCollapseClick: () -> Unit
) {
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.car_info_scene)
            .readBytes()
            .decodeToString()
    }

    val progress by animateFloatAsState(
        targetValue = if (scrollState.firstVisibleItemIndex in 0..1) 0f else 1f,
        tween(500)
    )
    val motionHeight by animateDpAsState(
        targetValue = if (scrollState.firstVisibleItemIndex in 0..1) 300.dp else 140.dp,
        tween(500)
    )

    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier
            .fillMaxWidth()
            .height(motionHeight)
    ) {
        Box(
            modifier = Modifier
                .layoutId("background_box")
                .background(colorResource(data.background))
        )
        Box(
            modifier = Modifier
                .layoutId("bottom_box_start")
                .clip(roundedTopStartShape)
                .background(MaterialTheme.colors.background)
        )
        Box(
            modifier = Modifier
                .layoutId("bottom_box_end")
                .clip(roundedTopEndShape)
                .background(MaterialTheme.colors.background)
        )
        Box(
            modifier = Modifier
                .layoutId("central_bottom_box")
                .background(MaterialTheme.colors.background)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(roundedBottomShape)
                    .background(colorResource(data.background))
            )
        }
        Text(
            text = "${data.chargePercent}%",
            color = MaterialTheme.colors.surface,
            modifier = Modifier.layoutId("percent")
        )
        Icon(
            painter = painterResource(R.drawable.bolt_solid),
            contentDescription = null,
            modifier = Modifier.layoutId("bolt_icon"),
            tint = MaterialTheme.colors.surface
        )
        Text(
            text = "${data.timeToEnd.title} ${data.timeToEnd.value}",
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .layoutId("end_to_time")
                .alpha(0.6f)
        )
        Icon(
            painter = painterResource(data.image),
            contentDescription = null,
            modifier = Modifier.layoutId("car_pic"),
            tint = MaterialTheme.colors.surface
        )
        Text(
            text = data.collapsingTitle,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .layoutId("collapse_title")
                .alpha(0.6f)
        )
        Text(
            text = data.collapsingSubtitle,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.h5,
            modifier = Modifier.layoutId("collapse_subtitle")
        )
        Text(
            text = data.title,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.layoutId("title")
        )
        Text(
            text = data.subtitle,
            color = MaterialTheme.colors.surface,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier
                .layoutId("subtitle")
                .alpha(0.6f)
        )
        IconButton(
            onClick = onCollapseClick,
            modifier = Modifier.layoutId("button")
        ) {
            Icon(
                painter = painterResource(R.drawable.chevron_down_solid),
                contentDescription = null,
                tint = MaterialTheme.colors.surface
            )
        }
        Canvas(
            modifier = Modifier
                .layoutId("circle")
                .background(Color.Transparent)
                .size(32.dp)
        ) {
            rotate(-145f) {
                drawCircle(
                    brush = Brush.sweepGradient(listOf(Color.White, Color.Gray)),
                    radius = 32.dp.toPx(),
                    style = Stroke(width = 4.dp.toPx())
                )
            }
        }
    }
}