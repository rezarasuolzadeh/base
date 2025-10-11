package ir.rezarasuolzadeh.base.ui.action

import ir.rezarasuolzadeh.base.ui.base.BaseAction

sealed interface HomeAction : BaseAction {
    data object OnGetTranslate : HomeAction
}