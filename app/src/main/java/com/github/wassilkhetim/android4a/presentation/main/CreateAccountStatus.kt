package com.github.wassilkhetim.android4a.presentation.main

sealed class CreateAccountStatus

object CreateAccountSuccess : CreateAccountStatus()
data class CreateAccountError(val errorMessage:String) : CreateAccountStatus()