package ir.rezarasuolzadeh.base.ui.viewmodel

import ir.rezarasuolzadeh.base.ui.action.SplashAction
import ir.rezarasuolzadeh.base.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.base.ui.base.BaseAction
import ir.rezarasuolzadeh.base.ui.base.BaseViewModel
import ir.rezarasuolzadeh.base.ui.state.SplashState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SplashViewModel : BaseViewModel() {

    private val state = MutableStateFlow(value = SplashState())
    val stateValue = state.asStateFlow()

    override fun onAction(action: BaseAction) {
        super.onAction(action)
        when (action) {
            is SplashAction.OnConfirmClick -> {
                onAction(
                    action = BaseAction.OnNavigateTo(
                        destination = AppNavigationDestination.Home()
                    )
                )
            }
        }
    }

    override fun onResetState() {
        // nothing to do yet
    }

}