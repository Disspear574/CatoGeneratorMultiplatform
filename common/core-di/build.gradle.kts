import ru.disspear574.catsapp.extension.commonDependencies

plugins {
    alias(libs.plugins.kmp)
}

android {
    namespace = "ru.disspear574.di"
}
kotlin {
    commonDependencies {
        implementation(libs.koin.core)

        implementation(projects.common.feature.cats.data)
        implementation(projects.common.feature.cats.domain)
        implementation(projects.common.feature.cats.presentation)
    }
}