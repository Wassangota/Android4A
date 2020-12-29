package com.github.wassilkhetim.android4a.injection

import android.content.Context
import androidx.room.Room
import com.github.wassilkhetim.android4a.data.local.AppDatabase
import com.github.wassilkhetim.android4a.data.local.DatabaseDao
import com.github.wassilkhetim.android4a.data.repository.UserRepository
import com.github.wassilkhetim.android4a.domain.usecase.CreateUserUseCase
import com.github.wassilkhetim.android4a.domain.usecase.GetUserUseCase
import com.github.wassilkhetim.android4a.domain.usecase.UserExistUseCase
import com.github.wassilkhetim.android4a.presentation.main.CreateAccountViewModel
import com.github.wassilkhetim.android4a.presentation.main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.security.AccessControlContext

val presentationModule = module{
    factory { MainViewModel(get(),get()) }
    factory { CreateAccountViewModel(get(),get()) }
}

val domainModule = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
    factory { UserExistUseCase(get()) }
}

val dataModule = module {
    single { UserRepository(get()) }
    single { createDatabase(androidContext()) }
}

fun createDatabase(context: Context): DatabaseDao {
    val appDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}