package com.github.wassilkhetim.android4a.domain.entity

class RestRickmortyResponse {
    private val info: InfoObjet? = null
    val results: List<PersonnageInfo?>? = null

    fun getInfo(): InfoObjet? {
        return info
    }
}