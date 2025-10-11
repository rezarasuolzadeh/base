package ir.rezarasuolzadeh.translator.ui.viewmodel

import androidx.lifecycle.viewModelScope
import ir.rezarasuolzadeh.translator.ui.action.SplashAction
import ir.rezarasuolzadeh.translator.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.translator.ui.base.BaseAction
import ir.rezarasuolzadeh.translator.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : BaseViewModel() {

    init {
        viewModelScope.launch {
            delay(timeMillis = 2000)
            onAction(action = SplashAction.OnSplashFinished)
        }
    }

    override fun onAction(action: BaseAction) {
        super.onAction(action)
        when (action) {
            is SplashAction.OnSplashFinished -> {
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