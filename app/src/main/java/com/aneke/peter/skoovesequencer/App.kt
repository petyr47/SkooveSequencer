package com.aneke.peter.skoovesequencer

import android.app.Application
import com.aneke.peter.skoovesequencer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {


    override fun onCreate() {
        super.onCreate()

        insertKoin()
    }

    private fun insertKoin() {
        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }


}