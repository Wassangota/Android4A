package com.github.wassilkhetim.android4a.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.wassilkhetim.android4a.domain.entity.User

@Entity
data class UserLocal(
    @ColumnInfo(name = "login") val login: String,
    @ColumnInfo(name = "password") val password: String
){
    @PrimaryKey( autoGenerate = true)
    var uid: Int? = null
}

fun User.toData() : UserLocal{
    return UserLocal(
        login = this.login,
        password = this.password
    )
}

fun UserLocal.toEntity() : User{
    return User(
        login = login,
        password = password
    )
}