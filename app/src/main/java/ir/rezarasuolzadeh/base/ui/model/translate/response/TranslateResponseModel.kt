package ir.rezarasuolzadeh.base.ui.model.translate.response

import ir.rezarasuolzadeh.base.data.dto.translate.response.TranslateResponseItemDto

data class TranslateResponseModel(
    val translations: List<TranslateResponseItemDto> = emptyList()
)