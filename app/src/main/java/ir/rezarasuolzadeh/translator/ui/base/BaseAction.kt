package ir.rezarasuolzadeh.translator.ui.base

interface BaseAction {
    data class OnNavigateTo(val destination: AppNavigationDestination) : BaseAction
}