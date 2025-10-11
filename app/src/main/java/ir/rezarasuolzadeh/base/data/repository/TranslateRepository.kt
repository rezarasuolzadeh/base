package ir.rezarasuolzadeh.base.data.repository

import ir.rezarasuolzadeh.base.ui.base.AppError
import ir.rezarasuolzadeh.base.ui.base.BaseResponse
import ir.rezarasuolzadeh.base.ui.base.Result
import ir.rezarasuolzadeh.base.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.base.ui.model.translate.response.TranslateResponseModel

interface TranslateRepository {
    suspend fun translate(request: TranslateRequestModel): Result<BaseResponse<TranslateResponseModel>, AppError>
}