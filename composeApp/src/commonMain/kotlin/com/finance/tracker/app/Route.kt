package com.finance.tracker.app

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object FinanceGraph: Route

    @Serializable
    data object OnBoardingScreen: Route

//    @Serializable
//    data object LoginScreen: Route

    @Serializable
    data object HomeScreen: Route
}