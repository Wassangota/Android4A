package com.github.wassilkhetim.android4a.domain.entity

class InfoObjet {
    private val count = 0
    private val pages = 0
    private val next: String? = null
    private val prev: String? = null

    fun getCount(): Int {
        return count
    }

    fun getPages(): Int {
        return pages
    }

    fun getNext(): String? {
        return next
    }

    fun getPrev(): String? {
        return prev
    }

}