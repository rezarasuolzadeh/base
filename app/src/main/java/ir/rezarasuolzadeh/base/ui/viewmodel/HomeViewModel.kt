package ir.rezarasuolzadeh.base.ui.viewmodel

import ir.rezarasuolzadeh.base.ui.action.HomeAction
import ir.rezarasuolzadeh.base.ui.base.BaseAction
import ir.rezarasuolzadeh.base.ui.base.BaseViewModel
import ir.rezarasuolzadeh.base.ui.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : BaseViewModel() {

    private val state = MutableStateFlow(value = HomeState())
    val stateValue = state.asStateFlow()

    override fun onAction(action: BaseAction) {
        super.onAction(action)
        when (action) {
            is HomeAction.OnFetchClick -> {
                // nothing to do yet
            }
        }
    }

    override fun onResetState() {
        // nothing to do yet
    }

}