package com.github.wassilkhetim.android4a.domain.usecase

import com.github.wassilkhetim.android4a.data.repository.UserRepository
import com.github.wassilkhetim.android4a.domain.entity.User

class CreateUserUseCase(private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}