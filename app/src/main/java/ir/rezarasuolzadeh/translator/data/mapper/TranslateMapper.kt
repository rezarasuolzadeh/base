package ir.rezarasuolzadeh.translator.data.mapper

import ir.rezarasuolzadeh.translator.data.dto.translate.request.TranslateRequestDto
import ir.rezarasuolzadeh.translator.data.dto.translate.response.TranslateResponseDto
import ir.rezarasuolzadeh.translator.data.dto.translate.response.TranslateResponseItemDto
import ir.rezarasuolzadeh.translator.ui.model.translate.request.TranslateRequestModel
import ir.rezarasuolzadeh.translator.ui.model.translate.response.TranslateResponseItemModel
import ir.rezarasuolzadeh.translator.ui.model.translate.response.TranslateResponseModel

fun TranslateResponseDto.toModel() = TranslateResponseModel(
    translations = translations
)

fun TranslateResponseItemDto.toModel() = TranslateResponseItemModel(
    translatedText = translatedText
)

fun TranslateRequestModel.toDto() = TranslateRequestDto(
    q = q,
    target = target
)