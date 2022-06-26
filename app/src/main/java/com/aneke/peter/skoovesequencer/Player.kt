package com.aneke.peter.skoovesequencer

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool

class Player(val context: Context) {

    private val AFiles = getAFiles()
    private val BFiles = getBFiles()

    val currentATrack = AFiles[0]
    val currentBTrack = BFiles[0]

    suspend fun play(mediaPlayer: MediaPlayer, file : AudioFile) {

        mediaPlayer.prepare()
        mediaPlayer.start()
    }

}