package ir.rezarasuolzadeh.translator.ui.screen

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
import ir.rezarasuolzadeh.translator.ui.base.AppNavigationDestination
import ir.rezarasuolzadeh.translator.ui.base.BaseAction
import ir.rezarasuolzadeh.translator.ui.base.BasePreview
import ir.rezarasuolzadeh.translator.ui.state.HomeState
import ir.rezarasuolzadeh.translator.ui.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun HomeRoot(
    viewModel: HomeViewModel,
    navigateTo: (AppNavigationDestination) -> Unit
) {
    val baseUiState by viewModel.baseUiStateValue.collectAsStateWithLifecycle()
    val state by viewModel.stateValue.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = baseUiState) {
        baseUiState.navigateToDestination?.let {
            navigateTo(it)
        }
    }

    HomeContainer(
        state = state,
        coroutineScope = coroutineScope,
        onAction = { action ->
            viewModel.onAction(action = action)
        }
    )
}

@Composable
fun HomeContainer(
    state: HomeState,
    coroutineScope: CoroutineScope,
    onAction: (BaseAction) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
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
                text = "Home Screen",
                color = Black,
                textAlign = TextAlign.Center,
                fontSize = 25.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() = BasePreview {
    HomeContainer(
        state = HomeState(),
        coroutineScope = rememberCoroutineScope()
    ) {
        // nothing to do yet
    }
}