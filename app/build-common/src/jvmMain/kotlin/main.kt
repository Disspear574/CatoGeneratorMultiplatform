import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import cats.presentation.CatsScreen
import cats.presentation.PlaySound
import di.KoinInjector
import java.awt.Dimension
import java.io.File
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

fun main() = application {
    val filePath = "./src/jvmMain/kotlin/cat_sound.wav"
    KoinInjector(JvmPlaySoundImpl(filePath)).koinApp
    val state = rememberWindowState(width = 818.dp, height = 767.dp)
    Window(
        title = "CatoGenerator",
        state = state,
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(818, 767)
        CatsScreen()
    }
}

private class JvmPlaySoundImpl(private val filePath: String) : PlaySound {
    override fun play() = playSound(filePath)
}

private fun playSound(filePath: String) {
    try {
        val fis = File(filePath)
        val playMP3: AudioInputStream = AudioSystem.getAudioInputStream(fis)
        val clip = AudioSystem.getClip();
        clip.open(playMP3)
        clip.start()
    } catch (e: Exception) {
        println(e)
    }
}
