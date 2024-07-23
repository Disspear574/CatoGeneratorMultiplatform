import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import ru.disspear574.catsapp.extension.iosTarget
import ru.disspear574.catsapp.internal.kmmExtension
import ru.disspear574.catsapp.internal.kotlinMultiplatformPluginId
import ru.disspear574.catsapp.internal.libraryExtension
import ru.disspear574.catsapp.internal.libraryPluginId
import ru.disspear574.catsapp.internal.libs


class KMPLibraryPlugin : Plugin<Project> {
    @OptIn(ExperimentalWasmDsl::class)
    override fun apply(target: Project) = with(target) {
        apply(plugin = libraryPluginId)
        apply(plugin = kotlinMultiplatformPluginId)

        kmmExtension {
            androidTarget()
            iosTarget()
            jvm()
        }
        libraryExtension {
            compileSdk = libs.versions.compileSDK.get().toInt()

            defaultConfig {
                minSdk = libs.versions.minSDK.get().toInt()
                compileSdk = libs.versions.compileSDK.get().toInt()

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

                consumerProguardFiles("consumer-rules.pro")
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_21
                targetCompatibility = JavaVersion.VERSION_21
            }
        }
    }
}