package com.github.wassilkhetim.android4a.domain.usecase

import com.github.wassilkhetim.android4a.data.repository.UserRepository

class UserExistUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(login:String) : Boolean{
        val nbUser = userRepository.getNumberUsers(login)
        return nbUser>0
    }
}