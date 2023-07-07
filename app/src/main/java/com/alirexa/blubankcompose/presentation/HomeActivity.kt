package com.alirexa.blubankcompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.alirexa.blubankcompose.presentation.composables.HomeScreen
import com.alirexa.blubankcompose.presentation.theme.BlubankComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val viewModel = hiltViewModel<HomeViewModel>()
            val state by viewModel.state.collectAsState()
            BlubankComposeTheme {
                HomeScreen(state)
            }
        }
    }
}