package com.aneke.peter.skoovesequencer.di

import com.aneke.peter.skoovesequencer.Conductor
import com.aneke.peter.skoovesequencer.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val singletonModule = module {
    single { Conductor(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}



val appModule = listOf(singletonModule, viewModelModule)