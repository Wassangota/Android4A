package com.github.wassilkhetim.android4a.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.wassilkhetim.android4a.domain.entity.User
import com.github.wassilkhetim.android4a.domain.usecase.CreateUserUseCase
import com.github.wassilkhetim.android4a.domain.usecase.GetUserUseCase
import kotlinx.coroutines.*

class MainViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {
    val loginLiveData: MutableLiveData<LoginStatus> = MutableLiveData()

    init {
    }

    fun onClickedLogin(login:String, password:String) {
        viewModelScope.launch(Dispatchers.IO) {
            //createUserUseCase.invoke(User("test"))
            val user = getUserUseCase.invoke(login,password)
            val loginStatus = if(user != null){
                LoginSuccess(user.login)
            }else{
                LoginError
            }

            withContext(Dispatchers.Main){
                loginLiveData.value = loginStatus
            }
        }
    }

}
