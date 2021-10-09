package com.example.chatapp

import android.app.Application
import timber.log.Timber

class Chatapp: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
    }
    private fun initTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}
