package com.alirexa.blubankcompose.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.google.accompanist.themeadapter.material.MdcTheme

@Composable
fun BlubankComposeTheme(
    content: @Composable () -> Unit
) {

    MdcTheme {
        CompositionLocalProvider(
            LocalLayoutDirection provides LayoutDirection.Rtl,
            content = content,
        )
    }
}