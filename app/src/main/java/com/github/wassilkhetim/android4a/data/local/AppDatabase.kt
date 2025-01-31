package com.github.wassilkhetim.android4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.wassilkhetim.android4a.data.local.models.PersonnageInfoLocal
import com.github.wassilkhetim.android4a.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class,
    PersonnageInfoLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}