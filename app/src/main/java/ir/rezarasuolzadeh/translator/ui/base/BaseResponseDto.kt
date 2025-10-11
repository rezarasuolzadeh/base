package ir.rezarasuolzadeh.translator.ui.base

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseResponseDto<T>(
    @Json(name = "data")
    val data: T
)