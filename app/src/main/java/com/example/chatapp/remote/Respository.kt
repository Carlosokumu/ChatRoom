package com.example.chatapp.remote

import com.example.chatapp.local.Daos.PartnerDao
import com.example.chatapp.local.Daos.UserDao

class Respository(val userDao: UserDao,val partnerDao: PartnerDao) {
}