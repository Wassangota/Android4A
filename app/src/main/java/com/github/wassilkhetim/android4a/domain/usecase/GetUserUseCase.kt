package com.github.wassilkhetim.android4a.domain.usecase

import com.github.wassilkhetim.android4a.data.repository.UserRepository
import com.github.wassilkhetim.android4a.domain.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(login: String, password: String) : User? {
        return userRepository.getUser(login, password)
    }
}