package com.aneke.peter.skoovesequencer

import android.os.Handler
import android.widget.ImageView
import androidx.core.content.ContextCompat

fun ImageView.emptyBlink() {
    val drawable = ContextCompat.getDrawable(context, R.drawable.empty_blink)
    setImageDrawable(drawable)
}

fun ImageView.lightBlink() {
    val drawable = ContextCompat.getDrawable(context, R.drawable.light_blink)
    setImageDrawable(drawable)
}

fun ImageView.blink() {
    lightBlink()
    Handler().postDelayed({
        emptyBlink() },
        100)
}