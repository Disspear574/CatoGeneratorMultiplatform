package cats.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Sync
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import cats.presentation.components.CatButton
import cats.presentation.components.CatImage
import cats.presentation.components.CatsTopBar
import cats.presentation.ui.theme.AppTheme
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory


@OptIn(ExperimentalCoilApi::class)
@Composable
fun CatsScreen(
    vm: CatsViewModel = viewModel { CatsViewModel() }
) {

    val state by vm.state.collectAsState()
    val hapticFeedback = LocalHapticFeedback.current

    setSingletonImageLoaderFactory { context ->
        newImageLoader(context, true)
    }
    AppTheme(

    ) {
        Scaffold(
            topBar = {
                CatsTopBar(title = "Генератор котов")
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CatImage(
                    img = state.cat?.image
                )

                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    CatButton(
                        title = "Создать кота",
                        image = Icons.Rounded.Sync,
                        onClick = vm::generateNewCat
                    )
                    Spacer(
                        modifier = Modifier.weight(0.1f)
                    )
                    CatButton(
                        title = "Погладить кота",
                        image = Icons.Rounded.Pets,
                        onClick = {
                            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                            vm.playSound.play()
                        }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                if (state.cat == null) state.error?.let { it1 -> Text(it1) }
            }

        }
    }
}
