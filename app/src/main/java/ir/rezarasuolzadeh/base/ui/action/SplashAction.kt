package ir.rezarasuolzadeh.base.ui.action

import ir.rezarasuolzadeh.base.ui.base.BaseAction

sealed interface SplashAction : BaseAction {
    data object OnConfirmClick : SplashAction
}