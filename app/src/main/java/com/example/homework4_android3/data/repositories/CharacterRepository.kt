package com.example.homework4_android3.data.repositories

import com.example.homework4_android3.App
import com.example.homework4_android3.models.CharacterModel
import com.example.homework4_android3.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    fun fetchCharacters(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        type: String? = null,
        gender: String? = null,
        onResponse: (data: RickAndMortyResponse<CharacterModel>) -> Unit,
        onFailure: (errorMassage: String) -> Unit
    ) {

        App.characterApi?.fetchCharacter(name, status, species, type, gender)
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        onResponse(response.body()!!)
                    }
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    onFailure(t.localizedMessage ?: "Error!")
                }
            })
    }
}