package com.aneke.peter.skoovesequencer

import android.content.Context
import android.content.res.AssetFileDescriptor
import android.graphics.drawable.Drawable
import java.io.IOException

fun getAllAudioFiles() : List<AudioFile> {
    val files = mutableListOf<AudioFile>()
    files.add(AudioFile("A1"))
    files.add(AudioFile("A2"))
    files.add(AudioFile("A3"))
    files.add(AudioFile("B1"))
    files.add(AudioFile("B2"))
    files.add(AudioFile("B3"))
    return files
}

fun getAFiles() : List<AudioFile> = getAllAudioFiles().filter { it.name.contains("A") }

fun getBFiles() : List<AudioFile> = getAllAudioFiles().filter { it.name.contains("B") }

fun loadImageFromAssets(context : Context, imageName : String) : Drawable? {
    try {
        val ins = context.assets.open(imageName)
        return Drawable.createFromStream(ins, null)
    } catch (e : IOException) {
        e.printStackTrace()
        return null
    }
}

fun loadAudioFromAssets(context : Context, audioResource : String) : AssetFileDescriptor? {
    try {
        return context.assets.openFd(audioResource)
    } catch (e : IOException) {
        e.printStackTrace()
        return null
    }
}