import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import ru.disspear574.catsapp.extension.commonDependencies
import ru.disspear574.catsapp.extension.jvmDependencies

plugins {
    alias(libs.plugins.composeMultiplatform)
}

android {
    namespace = "ru.disspear574"
}

kotlin {
    val xcFramework = XCFramework("Common")
    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Common"
            isStatic = true
            xcFramework.add(this)

            export(libs.koin.core)
            export(projects.common.coreDi)
            export(projects.common.feature.cats.data)
            export(projects.common.feature.cats.domain)
            export(projects.common.feature.cats.presentation)
        }
    }

    commonDependencies {
        api(projects.common.coreDi)
        api(projects.common.feature.cats.data)
        api(projects.common.feature.cats.domain)
        api(projects.common.feature.cats.presentation)
        api(libs.koin.core)
    }
    jvmDependencies {
        implementation(compose.desktop.currentOs)
        implementation(libs.kotlinx.coroutines.swing)

    }
}
compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ru.disspear574"
            packageVersion = "1.0.0"
        }
    }
}