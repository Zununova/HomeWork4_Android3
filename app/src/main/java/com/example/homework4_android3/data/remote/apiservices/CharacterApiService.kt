package com.example.homework4_android3.data.remote.apiservices

import com.example.homework4_android3.data.models.CharacterModel
import com.example.homework4_android3.data.models.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacter(
        @Query("name") name: String? = null,
        @Query("status") status: String? = null,
        @Query("Species") species: String? = null,
        @Query("type") type: String? = null,
        @Query("gender") gender: String? = null
    ): Response<RickAndMortyResponse<CharacterModel>>

    @GET("api/character/{id}")
    suspend fun fetchCharacterById(
        @Path("id") id: Int
    ): Response<CharacterModel>

}