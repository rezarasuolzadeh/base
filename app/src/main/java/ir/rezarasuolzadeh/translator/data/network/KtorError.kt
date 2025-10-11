package ir.rezarasuolzadeh.translator.data.network

import ir.rezarasuolzadeh.translator.ui.base.AppError

sealed class KtorError(override val message: String? = null) : AppError() {
    data class WebService(override val message: String?) : KtorError(message)
    data object RequestTimeOut : KtorError()
    data object NoInternet : KtorError()
    data object Server : KtorError()
    data object Serialization : KtorError()
    data object UnKnown : KtorError()
}