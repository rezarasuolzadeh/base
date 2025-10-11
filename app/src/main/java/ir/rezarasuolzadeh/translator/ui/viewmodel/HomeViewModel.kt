package ir.rezarasuolzadeh.translator.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import ir.rezarasuolzadeh.translator.data.repository.TranslateRepository
import ir.rezarasuolzadeh.translator.ui.action.HomeAction
import ir.rezarasuolzadeh.translator.ui.base.BaseAction
import ir.rezarasuolzadeh.translator.ui.base.BaseViewModel
import ir.rezarasuolzadeh.translator.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.translator.ui.state.HomeState
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