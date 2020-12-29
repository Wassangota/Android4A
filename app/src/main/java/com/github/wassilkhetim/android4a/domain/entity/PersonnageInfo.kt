package com.github.wassilkhetim.android4a.domain.entity

class PersonnageInfo {
    private val id: Int? = null
    private val name: String? = null
    private val status: String? = null
    private val species: String? = null
    private val type: String? = null
    private val gender: String? = null
    private val origin: LocationInfo? = null
    private val location: LocationInfo? = null
    private val image: String? = null
    private val episode: List<String?>? = null
    private val url: String? = null
    private val created: String? = null

    fun getId(): Int? {
        return id
    }

    fun getName(): String? {
        return name
    }

    fun getStatus(): String? {
        return status
    }

    fun getSpecies(): String? {
        return species
    }

    fun getType(): String? {
        return type
    }

    fun getGender(): String? {
        return gender
    }

    fun getOrigin(): LocationInfo? {
        return origin
    }

    fun getLocation(): LocationInfo? {
        return location
    }

    fun getImage(): String? {
        return image
    }

    fun getEpisode(): List<String?>? {
        return episode
    }

    fun getUrl(): String? {
        return url
    }

    fun getCreated(): String? {
        return created
    }

}