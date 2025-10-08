package ir.rezarasuolzadeh.base.ui.base

interface BaseAction {
    data class OnNavigateTo(val destination: AppNavigationDestination) : BaseAction
}