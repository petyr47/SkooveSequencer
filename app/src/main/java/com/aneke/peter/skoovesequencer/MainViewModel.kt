package com.aneke.peter.skoovesequencer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform

class MainViewModel(val conductor: Conductor) : ViewModel() {

    var p = 0
    var isPlaying = true

    val beats = conductor.beats
    val bars = conductor.bars
    val sixs = conductor.sixteenths

    val progress = flow<Int> {
        while (isPlaying){
            delay(200)
            p += 1
            if (p <= 100){
                emit(p)
            } else {
                p = 0
            }

        }
    }.flowOn(Dispatchers.Main)

    fun playOrPause() {
        conductor.play()
        conductor.isPlaying.value = false
    }

    val progData = conductor.musicTimeInMillis.transform<Int, Int> { convertToProgress(it) }.asLiveData()


    private fun convertToProgress(timeInSixs : Int) : Int{
        val totalTime = 15360
        val result = (timeInSixs / totalTime) * 100
        Log.e("conver", "RESULT ::::::::$result:::::::time ins $timeInSixs")
        return result
    }

    fun start() : Flow<Int> = flow{
        delay(100)
        emit(3)
    }

}