package com.example.jucrsampleapp.aboutcar.presentation.model

import androidx.annotation.StringRes

data class TitleModel(
    override val id: Int,
    @StringRes val title: Int,
    @StringRes val subtitle: Int? = null
): ItemModel(id)
