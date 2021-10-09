package com.example.chatapp.di

import androidx.room.Room
import com.example.chatapp.local.Database.AppDatabase
import com.example.chatapp.remote.Repository
import com.example.chatapp.viewmodels.MainViewmodel
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
private val repositoryModule: Module = module {
    single { Repository( userDao= get(),partnerDao = get()) }
}
private val mainviewmodel: Module= module {
    single { MainViewmodel(respository = get()) }
}
/*
    Aggregated modules
 */
val appModules: List<Module> = listOf(
    databaseModule,
    repositoryModule,
    mainviewmodel
)

