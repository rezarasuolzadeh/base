package ir.rezarasuolzadeh.base.data.webservice.translate

import ir.rezarasuolzadeh.base.data.dto.translate.request.TranslateRequestDto
import ir.rezarasuolzadeh.base.data.dto.translate.response.TranslateResponseDto
import ir.rezarasuolzadeh.base.ui.base.AppError
import ir.rezarasuolzadeh.base.ui.base.BaseResponseDto
import ir.rezarasuolzadeh.base.ui.base.Result

interface RemoteTranslateDataSource {
    suspend fun translate(request: TranslateRequestDto): Result<BaseResponseDto<TranslateResponseDto>, AppError>
}