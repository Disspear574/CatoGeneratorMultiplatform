import ru.disspear574.catsapp.extension.commonDependencies

plugins {
    alias(libs.plugins.kmp)
}

android {
    namespace = "ru.disspear574.cats.domain"
}

kotlin {
    commonDependencies {
        implementation(libs.koin.core)
    }
}
