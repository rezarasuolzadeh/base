package ir.rezarasuolzadeh.translator.data.network

import io.ktor.client.call.NoTransformationFoundException
import io.ktor.client.call.body
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import ir.rezarasuolzadeh.translator.ui.base.AppError
import ir.rezarasuolzadeh.translator.ui.base.BaseResponseDto
import ir.rezarasuolzadeh.translator.ui.base.Result
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.ensureActive
import java.net.ConnectException
import java.net.UnknownHostException

suspend inline fun <reified T : BaseResponseDto<*>> safeCall(
    executeRequest: () -> HttpResponse
): Result<T, AppError> {
    try {
        val response = try {
            executeRequest()
        } catch (e: SocketTimeoutException) {
            return Result.Error(error = KtorError.RequestTimeOut)
        } catch (e: UnresolvedAddressException) {
            return Result.Error(error = KtorError.NoInternet)
        } catch (e: UnknownHostException) {
            return Result.Error(error = KtorError.NoInternet)
        } catch (e: ConnectException) {
            return Result.Error(error = KtorError.NoInternet)
        } catch (e: Exception) {
            coroutineContext.ensureActive()
            return Result.Error(error = KtorError.UnKnown)
        }
        return responseToResult(response)
    } catch (e: Exception) {
        return Result.Error(error = KtorError.UnKnown)
    }
}

suspend inline fun <reified T : BaseResponseDto<*>> responseToResult(
    response: HttpResponse
): Result<T, AppError> {
    return when (response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(data = response.body<T>())
            } catch (e: NoTransformationFoundException) {
                Result.Error(error = KtorError.Serialization)
            }
        }

        in 500..599 -> {
            Result.Error(error = KtorError.Server)
        }

        else -> {
            Result.Error(error = KtorError.UnKnown)
        }
    }
}