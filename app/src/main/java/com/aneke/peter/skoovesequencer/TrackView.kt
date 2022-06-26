package com.aneke.peter.skoovesequencer

import android.content.Context
import android.media.Image
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View.OnTouchListener
import android.widget.ImageView
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.aneke.peter.skoovesequencer.databinding.TrackViewBinding


class TrackView  @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attrs,defStyleAttr){

    private val trackProgress : SeekBar
    private val forwardButton : ImageView
    private val trackImage : ImageView

    init {
        inflate(context, R.layout.track_view, this)

        trackProgress = findViewById(R.id.track_progress)
        forwardButton = findViewById(R.id.next_track_btn)
        trackImage = findViewById(R.id.track_image)

        trackProgress.isEnabled = false

    }
    
    fun setProgress(progress : Int) {
        Log.e("Track", ":::::$progress")
        trackProgress.progress = progress
    }

    fun pause() {

    }

    fun restart() {
        setProgress(0)
    }

    fun resume() {

    }
    
    fun setTrack(file : AudioFile) {

    }

}