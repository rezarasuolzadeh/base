package ir.rezarasuolzadeh.base.ui.routes

import kotlinx.serialization.Serializable

sealed interface MainRoutes : AppRoutes {

    @Serializable
    data object Splash : MainRoutes

    @Serializable
    data object Home : MainRoutes

}