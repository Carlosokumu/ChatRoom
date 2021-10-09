package com.example.chatapp.remote

import com.example.chatapp.local.Daos.PartnerDao
import com.example.chatapp.local.Daos.UserDao

class Repository(val userDao: UserDao, val partnerDao: PartnerDao) {
}