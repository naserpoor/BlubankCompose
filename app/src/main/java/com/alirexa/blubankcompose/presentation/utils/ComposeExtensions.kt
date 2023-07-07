package com.alirexa.blubankcompose.presentation.utils

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import java.text.NumberFormat
import java.util.Locale

@Composable
fun Dp.toPx(): Float = with(LocalDensity.current) {
    this@toPx.toPx()
}

@Composable
fun statusBarHeightPx(): Dp = with(LocalDensity.current) {
    WindowInsets.statusBars.asPaddingValues(this).calculateTopPadding()
}