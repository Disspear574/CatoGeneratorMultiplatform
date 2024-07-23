package ru.disspear574.catsapp.extension

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

fun KotlinMultiplatformExtension.iosTarget() {
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}

fun KotlinMultiplatformExtension.commonDependencies(
    configure: KotlinDependencyHandler.() -> Unit,
) = sourceSets.commonMain.dependencies { configure() }

fun KotlinMultiplatformExtension.androidDependencies(
    configure: KotlinDependencyHandler.() -> Unit,
) = sourceSets.androidMain.dependencies { configure() }

fun KotlinMultiplatformExtension.iosDependencies(
    configure: KotlinDependencyHandler.() -> Unit,
) = sourceSets.iosMain.dependencies { configure() }

fun KotlinMultiplatformExtension.wasmDependencies(
    configure: KotlinDependencyHandler.() -> Unit,
) = sourceSets.wasmJsMain.dependencies { configure() }

fun KotlinMultiplatformExtension.jvmDependencies(
    configure: KotlinDependencyHandler.() -> Unit,
) = sourceSets.jvmMain.dependencies { configure() }
