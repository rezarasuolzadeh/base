package ir.rezarasuolzadeh.base.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ir.rezarasuolzadeh.base.data.repository.TranslateRepository
import ir.rezarasuolzadeh.base.ui.action.HomeAction
import ir.rezarasuolzadeh.base.ui.base.BaseAction
import ir.rezarasuolzadeh.base.ui.base.BaseViewModel
import ir.rezarasuolzadeh.base.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.base.ui.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val translateRepository: TranslateRepository
) : BaseViewModel() {

    private val state = MutableStateFlow(value = HomeState())
    val stateValue = state.asStateFlow()

    var activateDeviceRequest: TranslateRequestModel by mutableStateOf(
        value = TranslateRequestModel()
    )
        private set

    override fun onAction(action: BaseAction) {
        super.onAction(action)
        when (action) {
            is HomeAction.OnGetTranslate -> {
                getTranslate()
            }
        }
    }

    private fun getTranslate() {
        callWebService(
            webService = {
                translateRepository.translate(
                    request = activateDeviceRequest
                )
            },
            onSuccess = { response ->
                // nothing to do yet
            }
        )
    }

    override fun onResetState() {
        // nothing to do yet
    }

}