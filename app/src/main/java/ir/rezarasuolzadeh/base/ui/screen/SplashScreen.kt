package ir.rezarasuolzadeh.base.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ir.rezarasuolzadeh.base.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.base.ui.base.BaseAction
import ir.rezarasuolzadeh.base.ui.base.BasePreview
import ir.rezarasuolzadeh.base.ui.state.SplashState
import ir.rezarasuolzadeh.base.ui.viewmodel.SplashViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun SplashRoot(
    viewModel: SplashViewModel,
    navigateTo: (AppNavigationDestination) -> Unit
) {
    val baseUiState by viewModel.baseUiStateValue.collectAsStateWithLifecycle()
    val state by viewModel.stateValue.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = state) {
        baseUiState.navigateToDestination?.let {
            navigateTo(it)
        }
    }

    SplashContainer(
        state = state,
        coroutineScope = coroutineScope,
        onAction = { action ->
            viewModel.onAction(action = action)
        }
    )
}

@Composable
fun SplashContainer(
    state: SplashState,
    coroutineScope: CoroutineScope,
    onAction: (BaseAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = White),
            text = "Splash Screen",
            color = Black,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashPreview() = BasePreview {
    SplashContainer(
        state = SplashState(),
        coroutineScope = rememberCoroutineScope()
    ) {
        // nothing to do yet
    }
}