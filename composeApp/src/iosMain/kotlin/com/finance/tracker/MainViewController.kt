package com.finance.tracker

import androidx.compose.ui.window.ComposeUIViewController
import com.finance.tracker.app.App
import com.finance.tracker.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }