plugins {
    `kotlin-dsl`
}

group = "ru.disspear574.catsapp"

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(libs.compose.gradle.plugin)
    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("kmp-library") {
            id = "kmp-library"
            implementationClass = "KMPLibraryPlugin"
        }
        register("compose-multiplatform") {
            id = "compose-multiplatform"
            implementationClass = "ComposeMultiplatformPlugin"
        }
    }
}