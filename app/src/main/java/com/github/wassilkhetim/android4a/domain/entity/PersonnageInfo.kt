package com.github.wassilkhetim.android4a.domain.entity

class PersonnageInfo(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationInfo,
    val location: LocationInfo,
    val image: String,
    val episode: List<String?>,
    val url: String,
    val created: String
) {


    /*fun getId(): Int? {
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
    }*/

}