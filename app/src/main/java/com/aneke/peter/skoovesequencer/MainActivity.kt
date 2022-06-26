package com.aneke.peter.skoovesequencer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.aneke.peter.skoovesequencer.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by viewModel()
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        mainViewModel.progData.observe(this) {
            Log.e("prog obs", ":::::$it")
            binding.aTrack.setProgress(it)
            binding.bTrack.setProgress(it)
        }

        mainViewModel.beats.observe(this){
            Log.e("beat obs", ":::::$it")
            binding.beatLed.blink()
        }

        mainViewModel.bars.observe(this){
            Log.e("bar obs", ":::::$it")
            binding.barLed.blink()
        }



        binding.playBtn.setOnClickListener { mainViewModel.playOrPause() }




    }
}