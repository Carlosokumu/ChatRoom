package com.example.chatapp.di

import androidx.room.Database
import androidx.room.Room
import com.example.chatapp.local.Database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "rest-database"
        ).build()
    }
}
/*
    Aggregated modules
 */
val appModules: List<Module> = listOf(
    databaseModule,
)

