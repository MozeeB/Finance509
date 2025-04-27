package com.finance.tracker.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.finance.tracker.finance.data.dto.onboarding.onBoardModelList
import com.finance.tracker.finance.presentation.onboarding.OnBoardingScreenRoot
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.FinanceGraph
        ) {
            navigation<Route.FinanceGraph>(
                startDestination = Route.OnBoardingScreen
            ) {
                composable<Route.OnBoardingScreen> {
//                    val viewModel = koinViewModel<HomeViewModel>()
                    OnBoardingScreenRoot(
                        pages = onBoardModelList,
                        onFinish = {
//                            Log.d("TAG", "App: onFinish")
//                            navController.navigate(Route.HomeScreen)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}