package com.github.wassilkhetim.android4a.data.local

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.wassilkhetim.android4a.data.local.models.PersonnageInfoLocal
import com.github.wassilkhetim.android4a.data.local.models.UserLocal

@Dao
interface DatabaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * from personnageinfolocal")
    fun getAllPersonnage(): List<PersonnageInfoLocal>

    @Query("SELECT * FROM userlocal WHERE login LIKE :login AND password LIKE :password LIMIT 1")
    fun findByEmail(login: String, password: String): UserLocal?

    @Query("SELECT count(*) FROM userlocal WHERE login LIKE :login")
    fun nbLogin(login: String): Int

    @Insert
    fun insert(user: UserLocal)

    @Insert
    fun insertPerso(personnageInfoLocal: PersonnageInfoLocal)

    @Query("DELETE FROM personnageinfolocal")
    fun clearPersonnageTable()

    @Delete
    fun delete(user: UserLocal)

}