package com.example.chatapp

import android.app.Application
import com.example.chatapp.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.logger.Level
import timber.log.Timber

class Chatapp: Application() {
    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }
    private fun initTimber(){
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
    private fun initKoin(){
        try {
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                modules(appModules)
            }
        }catch (error: KoinAppAlreadyStartedException){
            Timber.e(error.localizedMessage)
        }

    }
}
