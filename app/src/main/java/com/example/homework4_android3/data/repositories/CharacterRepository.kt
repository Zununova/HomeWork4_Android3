package com.example.homework4_android3.data.repositories

import com.example.homework4_android3.base.BaseRepository
import com.example.homework4_android3.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(private val service: CharacterApiService) :
    BaseRepository() {

    fun fetchCharacters(
        name: String?,
        status: String?,
        species: String?,
        type: String?,
        gender: String?
    ) = doRequest {
        service.fetchCharacter(name, status, species, type, gender)
    }

    fun fetchCharacterById(id: Int) = doRequest {
        service.fetchCharacterById(id)
    }
}