
rootProject.name = "CatoGeneratorMultiplatform"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
    }
}


include(":app:androidApp")
include(":app:build-common")

include(":common:core-di")

include(":common:feature:cats:data")
include(":common:feature:cats:domain")
include(":common:feature:cats:presentation")
