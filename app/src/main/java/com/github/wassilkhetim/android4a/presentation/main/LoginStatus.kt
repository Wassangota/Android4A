package com.github.wassilkhetim.android4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val login:String) : LoginStatus()
object LoginError : LoginStatus()