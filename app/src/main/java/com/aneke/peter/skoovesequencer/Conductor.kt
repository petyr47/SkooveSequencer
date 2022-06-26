package com.aneke.peter.skoovesequencer

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class Conductor(val context: Context, val player: Player) {

    var time = 0
    val sixteenths = MutableLiveData(0)
    val beats = Transformations.map(sixteenths) {it/4}
    val bars = Transformations.map(beats) {it/4}
    val isPlaying = MutableLiveData(true)

    val musicTimeInMillis : Flow<Int> = flow {
        while(isPlaying.value.safeBoolean()) {
            delay(120)
            time++
            Log.e("time",":::::::::time:::$time")
            sixteenths.postValue(time)
            emit(time)
        }
    }




    fun play() {
        try {
            val APlayer = MediaPlayer()
            //val BPlayer = MediaPlayer()

//            val Atrack = loadAudioFromAssets(context, currentATrack.audioResource)
//            val Btrack = loadAudioFromAssets(context, currentBTrack.audioResource)
//            Atrack?.let { APlayer.setDataSource(Atrack.fileDescriptor, Atrack.startOffset, Atrack.length)  }
          //  Btrack?.let { APlayer.setDataSource(Btrack.fileDescriptor, Btrack.startOffset, Btrack.length)  }

            APlayer.prepare()
            APlayer.start()

//            BPlayer.prepare()
//            BPlayer.start()
        } catch (e : Exception) {
            e.printStackTrace()
        }
    }

    fun pause() {

    }

    fun reset() {

    }

    fun queueNextTrack(isA : Boolean = true) {

    }






}