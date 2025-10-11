package ir.rezarasuolzadeh.translator.ui.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.rezarasuolzadeh.translator.ui.routes.MainRoutes
import ir.rezarasuolzadeh.translator.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.translator.ui.screen.HomeRoot
import ir.rezarasuolzadeh.translator.ui.screen.SplashRoot
import ir.rezarasuolzadeh.translator.ui.viewmodel.HomeViewModel
import ir.rezarasuolzadeh.translator.ui.viewmodel.SplashViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.let

@Composable
fun NavigationGraph(navHostController: NavHostController) {

    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val onBackPressed = {
        navHostController.navigateUp()
    }

    val backToHome = {
        navHostController.navigate(route = MainRoutes.Home) {
            popUpTo(navHostController.graph.startDestinationId) {
                inclusive = true
            }
        }
    }

    val navigateTo: (AppNavigationDestination) -> Unit = { destination ->
        when (destination) {
            is AppNavigationDestination.NavigateUp -> onBackPressed()
            is AppNavigationDestination.Home -> backToHome()
            else -> {
                destination.route?.let { route ->
                    navHostController.navigate(
                        route
                    )
                }
            }
        }
    }

    NavHost(
        navController = navHostController,
        startDestination = MainRoutes.Splash
    ) {
        composable<MainRoutes.Splash> {
            val viewModel = koinViewModel<SplashViewModel>()
            SplashRoot(
                viewModel = viewModel,
                navigateTo = { destination ->
                    navigateTo(destination)
                }
            )
        }

        composable<MainRoutes.Home> {
            val viewModel = koinViewModel<HomeViewModel>()
            HomeRoot(
                viewModel = viewModel,
                navigateTo = { destination ->
                    navigateTo(destination)
                }
            )
        }
    }

}