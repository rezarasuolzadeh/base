package ir.rezarasuolzadeh.translator.data.repository

import ir.rezarasuolzadeh.translator.data.mapper.toDto
import ir.rezarasuolzadeh.translator.data.mapper.toModel
import ir.rezarasuolzadeh.translator.data.webservice.translate.RemoteTranslateDataSource
import ir.rezarasuolzadeh.translator.ui.base.AppError
import ir.rezarasuolzadeh.translator.ui.base.BaseResponse
import ir.rezarasuolzadeh.translator.ui.base.Result
import ir.rezarasuolzadeh.translator.ui.base.map
import ir.rezarasuolzadeh.translator.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.translator.ui.model.translate.response.TranslateResponseModel

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