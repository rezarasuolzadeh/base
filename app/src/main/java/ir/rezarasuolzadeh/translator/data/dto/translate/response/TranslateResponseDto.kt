package ir.rezarasuolzadeh.translator.data.dto.translate.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TranslateResponseDto(
    @Json(name = "translations")
    val translations: List<TranslateResponseItemDto> = emptyList()
)