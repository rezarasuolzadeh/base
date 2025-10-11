package ir.rezarasuolzadeh.translator.data.dto.translate.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TranslateResponseItemDto(
    @Json(name = "translatedText")
    val translatedText: String
)