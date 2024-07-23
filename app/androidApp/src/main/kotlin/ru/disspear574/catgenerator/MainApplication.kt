package ru.disspear574.catgenerator

import android.app.Application
import di.KoinInjector

class MainApplication : Application() {
    companion object {
        lateinit var INSTANCE: MainApplication
    }

    override fun onCreate() {
        super.onCreate()

        KoinInjector(PlaySoundAndroid(this)).koinApp
        INSTANCE = this
    }
}