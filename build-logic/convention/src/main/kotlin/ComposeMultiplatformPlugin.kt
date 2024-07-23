
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import ru.disspear574.catsapp.extension.commonDependencies
import ru.disspear574.catsapp.internal.composeCompilerPluginId
import ru.disspear574.catsapp.internal.composeMainPluginId
import ru.disspear574.catsapp.internal.kmmExtension
import ru.disspear574.catsapp.internal.kmpLibraryPlugin
import ru.disspear574.catsapp.internal.libraryExtension
import ru.disspear574.catsapp.internal.libs

class ComposeMultiplatformPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        apply(plugin = kmpLibraryPlugin)
        apply(plugin = composeCompilerPluginId)
        apply(plugin = composeMainPluginId)

        kmmExtension {
            commonDependencies {
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)
                implementation(libs.compose.material3)
                implementation(libs.compose.ui)
            }
        }
        libraryExtension {
            buildFeatures {
                compose = true
            }
        }
    }
}