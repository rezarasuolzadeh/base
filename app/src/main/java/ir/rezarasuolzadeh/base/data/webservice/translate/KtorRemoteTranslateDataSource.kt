package ir.rezarasuolzadeh.base.data.webservice.translate

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import ir.rezarasuolzadeh.base.data.constant.TRANSLATE_END_POINT
import ir.rezarasuolzadeh.base.data.dto.translate.request.TranslateRequestDto
import ir.rezarasuolzadeh.base.data.dto.translate.response.TranslateResponseDto
import ir.rezarasuolzadeh.base.data.network.safeCall
import ir.rezarasuolzadeh.base.ui.base.AppError
import ir.rezarasuolzadeh.base.ui.base.BaseResponseDto
import ir.rezarasuolzadeh.base.ui.base.Result

class KtorRemoteTranslateDataSource(private val httpClient: HttpClient) : RemoteTranslateDataSource {

    override suspend fun translate(request: TranslateRequestDto): Result<BaseResponseDto<TranslateResponseDto>, AppError> {
        return safeCall {
            httpClient.post(urlString = TRANSLATE_END_POINT) {
                setBody(body = request)
            }.body()
        }
    }

}