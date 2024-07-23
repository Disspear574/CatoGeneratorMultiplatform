import ru.disspear574.catsapp.extension.androidDependencies
import ru.disspear574.catsapp.extension.commonDependencies
import ru.disspear574.catsapp.extension.iosDependencies
import ru.disspear574.catsapp.extension.wasmDependencies
import ru.disspear574.catsapp.extension.jvmDependencies

plugins {
    alias(libs.plugins.kmp)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "ru.disspear574.cats.data"
}

kotlin {
    androidDependencies {
        implementation(libs.ktor.client.okhttp)
    }
    commonDependencies {
        implementation(projects.common.feature.cats.domain)

        implementation(libs.koin.core)

        implementation(libs.ktor.core)
        implementation(libs.ktor.content.negotiation)
        implementation(libs.ktor.logger)
        implementation(libs.ktor.kotlinx.serialization.json)
        implementation(libs.kotlinx.serialization.json)
    }
    iosDependencies {
        implementation(libs.ktor.client.darwin)
    }
    jvmDependencies {
        implementation(libs.ktor.client.okhttp)
    }
}