package ir.rezarasuolzadeh.base.data.repository

import ir.rezarasuolzadeh.base.data.mapper.toDto
import ir.rezarasuolzadeh.base.data.mapper.toModel
import ir.rezarasuolzadeh.base.data.webservice.translate.RemoteTranslateDataSource
import ir.rezarasuolzadeh.base.ui.base.AppError
import ir.rezarasuolzadeh.base.ui.base.BaseResponse
import ir.rezarasuolzadeh.base.ui.base.Result
import ir.rezarasuolzadeh.base.ui.base.map
import ir.rezarasuolzadeh.base.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.base.ui.model.translate.response.TranslateResponseModel

class TranslateRepositoryImpl(
    private val remoteTranslateDatasource: RemoteTranslateDataSource
) : TranslateRepository {

    override suspend fun translate(request: TranslateRequestModel): Result<BaseResponse<TranslateResponseModel>, AppError> {
        return remoteTranslateDatasource.translate(request = request.toDto()).map { baseDto ->
            with(receiver = baseDto) {
                BaseResponse(
                    data = data.toModel()
                )
            }
        }
    }

}