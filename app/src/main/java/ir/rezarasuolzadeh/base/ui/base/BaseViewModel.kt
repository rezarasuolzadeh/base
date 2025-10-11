package ir.rezarasuolzadeh.base.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel() {

    protected val baseUiState = MutableStateFlow(value = BaseUiState())
    val baseUiStateValue = baseUiState.asStateFlow()

    protected fun <T> callWebService(
        webService: suspend () -> Result<BaseResponse<T>, AppError>,
        onSuccess: (T) -> Unit = { data -> },
        onError: (String, T?) -> Unit = { message, data -> },
        showLoading: Boolean = true,
        toastErrorMessage: Boolean = true
    ) {
        viewModelScope.launch {
            updateLoadingState(isLoading = showLoading)
            webService().onSuccess { response ->
                onSuccess(response.data)
            }.onError { error, response ->
                updateLoadingState(isLoading = false)
                if (toastErrorMessage) {
                    updateErrorMessageState(errorMessage = error)
                }
                onError(error.message.orEmpty(), response?.data)
            }
        }
    }

    protected fun updateLoadingState(isLoading: Boolean) {
        baseUiState.update {
            it.copy(isLoading = isLoading)
        }
    }

    protected fun updateErrorMessageState(errorMessage: AppError) {
        baseUiState.update {
            it.copy(errorMessage = errorMessage)
        }
    }

    protected fun resetBaseUiState() {
        baseUiState.value = BaseUiState()
    }

    open fun onAction(action: BaseAction) {
        when (action) {
            is BaseAction.OnNavigateTo -> {
                baseUiState.update {
                    it.copy(navigateToDestination = action.destination)
                }
            }
        }
    }

    protected abstract fun onResetState()

}