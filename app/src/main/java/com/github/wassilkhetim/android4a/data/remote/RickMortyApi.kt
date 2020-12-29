package com.github.wassilkhetim.android4a.data.remote

import com.github.wassilkhetim.android4a.domain.entity.RestRickmortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApi {

    @GET("/api/character/")
    fun getRickmortyResponse(@Query("page") valeur: Int): Call<RestRickmortyResponse>

}