package ir.rezarasuolzadeh.translator.ui.base

sealed interface Result<out D, out E : AppError> {
    data class Success<out D>(val data: D) : Result<D, Nothing>
    data class Error<out E : AppError, out D>(val error: E, val data: D? = null) : Result<D, E>
}

inline fun <T : BaseResponseDto<*>, E : AppError, R : BaseResponse<*>> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Error -> Result.Error(error = error, data = data?.let(block = map))
        is Result.Success -> Result.Success(data = map(data))
    }
}

inline fun <T : BaseResponse<*>, E : AppError> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T : BaseResponse<*>, E : AppError> Result<T, E>.onError(action: (E, T?) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> {
            action(error, data)
            this
        }

        is Result.Success -> this
    }
}