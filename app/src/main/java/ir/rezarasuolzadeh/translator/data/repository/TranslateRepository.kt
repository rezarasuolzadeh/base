package ir.rezarasuolzadeh.translator.data.repository

import ir.rezarasuolzadeh.translator.ui.base.AppError
import ir.rezarasuolzadeh.translator.ui.base.BaseResponse
import ir.rezarasuolzadeh.translator.ui.base.Result
import ir.rezarasuolzadeh.translator.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.translator.ui.model.translate.response.TranslateResponseModel

interface TranslateRepository {
    suspend fun translate(request: TranslateRequestModel): Result<BaseResponse<TranslateResponseModel>, AppError>
}