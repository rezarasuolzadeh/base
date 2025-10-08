package ir.rezarasuolzadeh.base.ui.base

import ir.rezarasuolzadeh.base.ui.routes.AppRoutes
import ir.rezarasuolzadeh.base.ui.routes.MainRoutes

data class BaseUiState(
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: String? = null,
    val navigateToDestination: AppNavigationDestination? = null
)

sealed interface AppNavigationDestination {
    val route: AppRoutes?

    data class NavigateUp(override val route: AppRoutes? = null) : AppNavigationDestination
    data class Splash(override val route: MainRoutes.Splash = MainRoutes.Splash) : AppNavigationDestination
    data class Home(override val route: MainRoutes.Home = MainRoutes.Home) : AppNavigationDestination
}