package ir.rezarasuolzadeh.base.ui.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun BasePreview(content: @Composable BoxScope.() -> Unit) {
    CompositionLocalProvider(value = LocalLayoutDirection provides LayoutDirection.Rtl) {
        Box {
            content()
        }
    }
}