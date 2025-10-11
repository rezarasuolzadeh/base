package ir.rezarasuolzadeh.translator.data.dto.translate.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TranslateRequestDto(
    @Json(name = "q")
    val q: String,

    @Json(name = "target")
    val target: String
)