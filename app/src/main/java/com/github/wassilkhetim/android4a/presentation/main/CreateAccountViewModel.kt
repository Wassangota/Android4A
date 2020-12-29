package com.github.wassilkhetim.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wassilkhetim.android4a.domain.entity.User
import com.github.wassilkhetim.android4a.domain.usecase.CreateUserUseCase
import com.github.wassilkhetim.android4a.domain.usecase.UserExistUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CreateAccountViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val userExistUseCase: UserExistUseCase
) : ViewModel() {
    val createAccountLiveData : MutableLiveData<CreateAccountStatus> = MutableLiveData()

    fun onClickedCreate(login:String,password:String){
        viewModelScope.launch(Dispatchers.IO) {
            if(!userExistUseCase.invoke(login)){
                createUserUseCase.invoke(User(
                    login
                    ,password))
                withContext(Dispatchers.Main){
                    createAccountLiveData.value = CreateAccountSuccess
                }
            }else{
                withContext(Dispatchers.Main){
                    createAccountLiveData.value = CreateAccountError("Login is already used!")
                }
            }
        }
    }

}