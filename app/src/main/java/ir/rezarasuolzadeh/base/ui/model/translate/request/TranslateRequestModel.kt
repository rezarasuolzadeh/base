package ir.rezarasuolzadeh.base.ui.model.translate.request

import ir.rezarasuolzadeh.base.data.constant.FA

data class TranslateRequestModel(
    var q: String = "",
    var target: String = FA
)