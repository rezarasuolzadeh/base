package ir.rezarasuolzadeh.translator.ui.model.translate.response

import ir.rezarasuolzadeh.translator.data.dto.translate.response.TranslateResponseItemDto

data class TranslateResponseModel(
    val translations: List<TranslateResponseItemDto> = emptyList()
)