package com.github.wassilkhetim.android4a.domain.usecase

import com.github.wassilkhetim.android4a.data.local.models.toData
import com.github.wassilkhetim.android4a.data.repository.PersonnageInfoRepository
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo

class SavePersonnagesUseCase(
    private val personnageInfoRepository: PersonnageInfoRepository
) {

    suspend fun invoke(personnageList: MutableList<PersonnageInfo>){
        for (i in personnageList){
            personnageInfoRepository.addPersonnage(i)
        }
    }

}