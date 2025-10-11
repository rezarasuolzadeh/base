package ir.rezarasuolzadeh.translator.ui.action

import ir.rezarasuolzadeh.translator.ui.base.BaseAction

sealed interface SplashAction : BaseAction {
    data object OnSplashFinished : SplashAction
}