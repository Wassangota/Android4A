package com.github.wassilkhetim.android4a.data.repository

import com.github.wassilkhetim.android4a.data.local.DatabaseDao
import com.github.wassilkhetim.android4a.data.local.models.toData
import com.github.wassilkhetim.android4a.data.local.models.toEntity
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo

class PersonnageInfoRepository(
    private val databaseDao: DatabaseDao
) {

    suspend fun addPersonnage(personnageInfo: PersonnageInfo){
        databaseDao.insertPerso(personnageInfo.toData())
    }

    fun getPersonnages(): MutableList<PersonnageInfo>{
        val listPersoLocal = databaseDao.getAllPersonnage()
        val listPerso: MutableList<PersonnageInfo> = ArrayList()
        for(i in listPersoLocal){
            listPerso.add(i.toEntity())
        }
        return listPerso
    }

    fun clearTablespace(){
        databaseDao.clearPersonnageTable()
    }

}