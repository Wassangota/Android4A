package com.github.wassilkhetim.android4a.data.repository

import com.github.wassilkhetim.android4a.data.local.DatabaseDao
import com.github.wassilkhetim.android4a.data.local.models.toData
import com.github.wassilkhetim.android4a.data.local.models.toEntity
import com.github.wassilkhetim.android4a.domain.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
) {

    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User {
        val userLocal = databaseDao.findByEmail(email)
        return userLocal.toEntity()
    }

}