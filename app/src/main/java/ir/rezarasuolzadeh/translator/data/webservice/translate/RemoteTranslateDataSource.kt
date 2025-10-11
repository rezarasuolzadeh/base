package ir.rezarasuolzadeh.translator.data.webservice.translate

import ir.rezarasuolzadeh.translator.data.dto.translate.request.TranslateRequestDto
import ir.rezarasuolzadeh.translator.data.dto.translate.response.TranslateResponseDto
import ir.rezarasuolzadeh.translator.ui.base.AppError
import ir.rezarasuolzadeh.translator.ui.base.BaseResponseDto
import ir.rezarasuolzadeh.translator.ui.base.Result

interface RemoteTranslateDataSource {
    suspend fun translate(request: TranslateRequestDto): Result<BaseResponseDto<TranslateResponseDto>, AppError>
}