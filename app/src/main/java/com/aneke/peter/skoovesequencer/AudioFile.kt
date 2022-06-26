package com.aneke.peter.skoovesequencer

data class AudioFile(
    val name : String,
    val imageResource : String = "$name.jpg",
    val audioResource : String = "$name.wav",
)



