package com.example.jucrsampleapp.aboutcar.presentation.utils

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

private const val DRAWABLE_RESOURCE_TYPE = "drawable"
private const val COLOR_RESOURCE_TYPE = "color"
private const val NO_SUCH_RES_ID = 0

@ActivityRetainedScoped
class ResourcesWrapper
@Inject constructor(
    @ActivityContext private val context: Context
){

    fun getDrawableIdentifier(name: String): Int? {
        return getIdentifier(name, DRAWABLE_RESOURCE_TYPE)
            .takeIf { it != NO_SUCH_RES_ID }
    }

    fun getColorIdentifier(name: String): Int? {
        return getIdentifier(name, COLOR_RESOURCE_TYPE)
            .takeIf { it != NO_SUCH_RES_ID }
    }

    private fun getIdentifier(name: String, type: String): Int {
        return context.resources.getIdentifier(name, type, context.packageName)
    }
}