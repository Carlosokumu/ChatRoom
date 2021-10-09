package com.example.chatapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chatapp.local.Daos.PartnerDao
import com.example.chatapp.local.Daos.UserDao
import com.example.chatapp.local.Entities.PartnerInfo
import com.example.chatapp.local.Entities.UserInfo

@Database(entities = [UserInfo::class,PartnerInfo::class],exportSchema = false,version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun PartnerDao(): PartnerDao
}