package ir.rezarasuolzadeh.translator.ui.base

import ir.rezarasuolzadeh.translator.ui.routes.AppRoutes
import ir.rezarasuolzadeh.translator.ui.routes.MainRoutes

data class BaseUiState(
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: AppError? = null,
    val navigateToDestination: AppNavigationDestination? = null
)

sealed interface AppNavigationDestination {
    val route: AppRoutes?

    data class NavigateUp(override val route: AppRoutes? = null) : AppNavigationDestination
    data class Splash(override val route: MainRoutes.Splash = MainRoutes.Splash) : AppNavigationDestination
    data class Home(override val route: MainRoutes.Home = MainRoutes.Home) : AppNavigationDestination
}