package com.github.wassilkhetim.android4a.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.wassilkhetim.android4a.domain.entity.LocationInfo
import com.github.wassilkhetim.android4a.domain.entity.PersonnageInfo

@Entity
data class PersonnageInfoLocal(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "species") val species: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "gender") val gender: String,
    @ColumnInfo(name = "origin") val origin: String,
    @ColumnInfo(name = "location") val location: String,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "create") val created: String
)

fun PersonnageInfo.toData() : PersonnageInfoLocal{
    return PersonnageInfoLocal(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = origin.name,
        location = location.name,
        image = image,
        url = url,
        created = created
    )
}

fun PersonnageInfoLocal.toEntity() : PersonnageInfo{
    return PersonnageInfo(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = LocationInfo(origin,"null"),
        location = LocationInfo(location,"null"),
        image = image,
        episode = ArrayList<String>(),
        url = url,
        created = created
    )
}