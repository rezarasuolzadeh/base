package ir.rezarasuolzadeh.translator.ui.model.translate.request

import ir.rezarasuolzadeh.translator.data.constant.FA

data class TranslateRequestModel(
    var q: String = "",
    var target: String = FA
)