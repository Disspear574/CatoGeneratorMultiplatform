import ru.disspear574.catsapp.extension.androidDependencies
import ru.disspear574.catsapp.extension.commonDependencies

plugins {
    alias(libs.plugins.composeMultiplatform)
}

android {
    namespace = "ru.disspear574.cats.presentation"
}


kotlin {
    androidDependencies {
        implementation(libs.lifecycle.compose)
    }
    commonDependencies {
        implementation(projects.common.feature.cats.domain)

        implementation(libs.koin.core)
//        implementation(libs.koin.compose)
//
        implementation(libs.lifecycle.compose.viewmodel)
//
        implementation(libs.compose.icons.extended)

        implementation(libs.ktor.core)
        implementation(libs.coil)
        implementation(libs.coil.compose)
        implementation(libs.coil.network.ktor)

    }
}