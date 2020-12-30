package com.github.wassilkhetim.android4a.domain.usecase

import com.github.wassilkhetim.android4a.data.repository.PersonnageInfoRepository
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo

class GetPersonnagesUseCase(
    private val personnageInfoRepository: PersonnageInfoRepository
){
    suspend fun getPersonnages(): MutableList<PersonnageInfo> {
        return personnageInfoRepository.getPersonnages()
    }
}