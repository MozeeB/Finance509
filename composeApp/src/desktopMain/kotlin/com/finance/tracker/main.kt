package com.finance.tracker

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.finance.tracker.app.App
import com.finance.tracker.di.initKoin

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Finance509",
    ) {
        App()
    }
}