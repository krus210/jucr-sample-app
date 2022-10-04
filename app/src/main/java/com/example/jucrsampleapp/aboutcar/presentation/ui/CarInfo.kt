package com.example.jucrsampleapp.aboutcar.presentation.ui.carinfo

import androidx.compose.runtime.Composable
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jucrsampleapp.aboutcar.presentation.model.CarInfo
import com.example.jucrsampleapp.aboutcar.presentation.state.CarInfoState
import java.lang.reflect.Modifier

@Composable
fun CarInfo(state: CarInfoState, onCollapseClick: () -> Unit) {
    when (state) {
        is CarInfoState.Success -> CarInfoSuccess(state.data, state.isCollapsed, onCollapseClick)
        is CarInfoState.Loading -> CarInfoLoading(state.isCollapsed)
        is CarInfoState.Error -> CarInfoError(state.message, state.isCollapsed)
    }
}

@Composable
fun CarInfoSuccess(
    data: CarInfo,
    isCollapsed: Boolean,
    onCollapseClick: () -> Unit
) {

}

@Composable
fun CarInfoLoading(
    isCollapsed: Boolean
) {
    //TODO
}

@Composable
fun CarInfoError(
    message: String?,
    isCollapsed: Boolean
) {
   //TODO
}
