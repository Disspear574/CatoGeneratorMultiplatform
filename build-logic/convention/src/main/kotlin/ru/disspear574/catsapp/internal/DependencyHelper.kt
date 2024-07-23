package ru.disspear574.catsapp.internal

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider

internal fun DependencyHandler.implementation(provider: Provider<MinimalExternalModuleDependency>): Dependency? =
    add("implementation", provider)

internal fun DependencyHandler.debugImplementation(provider: Provider<MinimalExternalModuleDependency>): Dependency? =
    add("debugImplementation", provider)