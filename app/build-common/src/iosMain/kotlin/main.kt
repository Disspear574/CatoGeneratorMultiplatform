import androidx.compose.ui.window.ComposeUIViewController
import cats.presentation.CatsScreen
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    CatsScreen()
}
