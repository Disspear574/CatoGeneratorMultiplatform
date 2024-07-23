package ru.disspear574.catgenerator

import android.content.Context
import android.media.MediaPlayer
import cats.presentation.PlaySound

class PlaySoundAndroid(private val context: Context): PlaySound {
    override fun play() = playSound(context)
}

private fun playSound(context: Context) {
    val player = MediaPlayer.create(context, R.raw.cat_sound)
    player.start()
}