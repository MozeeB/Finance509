package com.finance.tracker.finance.data.dto.onboarding

import androidx.compose.ui.input.key.Key.Companion.R

data class OnBoardModel(
    val imageRes: Int,
    val title: String,
    val description: String
)

val onBoardModelList = listOf(
    OnBoardModel(
        title = "Groceries at Your Fingertips",
        description = "Find the favorites your store your want by your locations on neighborhood.",
        imageRes = 0
    ),
    OnBoardModel(
        title = "Fresh Delivered, Hassle Free",
        description = "Find the favorites your store your want by your locations on neighborhood.",
        imageRes = 0
    ),
    OnBoardModel(
        title = "Shop Smart. Eat Fresh",
        description = "Find the favorites your store your want by your locations on neighborhood.",
        imageRes = 0
    )
)