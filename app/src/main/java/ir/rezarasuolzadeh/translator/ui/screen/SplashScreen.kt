package ir.rezarasuolzadeh.translator.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.rezarasuolzadeh.translator.R
import ir.rezarasuolzadeh.translator.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.translator.ui.base.BasePreview
import ir.rezarasuolzadeh.translator.ui.viewmodel.SplashViewModel

@Composable
fun SplashRoot(
    viewModel: SplashViewModel,
    navigateTo: (AppNavigationDestination) -> Unit
) {
    val baseUiState by viewModel.baseUiStateValue.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = baseUiState) {
        baseUiState.navigateToDestination?.let {
            navigateTo(it)
        }
    }

    SplashContainer()
}

@Composable
fun SplashContainer() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black)
    ) {
        Image(
            modifier = Modifier
                .size(size = 120.dp)
                .padding(bottom = 12.dp)
                .fillMaxWidth(fraction = .1f)
                .align(alignment = Alignment.Center),
            painter = painterResource(id = R.drawable.ic_translate),
            contentDescription = "transaction situation"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashPreview() = BasePreview {
    SplashContainer()
}