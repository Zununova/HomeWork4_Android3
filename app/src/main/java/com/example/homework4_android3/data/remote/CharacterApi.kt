package com.example.homework4_android3.data.remote

import com.example.homework4_android3.models.CharacterModel
import com.example.homework4_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("api/character")
    fun fetchCharacter(
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("Species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null
    ): Call<RickAndMortyResponse<CharacterModel>>
}