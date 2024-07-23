package ru.disspear574.catsapp.internal

import KMPLibraryPlugin
import org.gradle.api.Project

internal val Project.libraryPluginId
    get() = libs.plugins.android.library.get().pluginId

internal val Project.composeCompilerPluginId
    get() = libs.plugins.compose.compiler.get().pluginId

internal val Project.kotlinMultiplatformPluginId
    get() = libs.plugins.multiplatform.get().pluginId

internal val Project.composeMainPluginId
    get() = libs.plugins.compose.jb.get().pluginId


internal val Project.kmpLibraryPlugin
    get() = libs.plugins.kmp.get().pluginId
