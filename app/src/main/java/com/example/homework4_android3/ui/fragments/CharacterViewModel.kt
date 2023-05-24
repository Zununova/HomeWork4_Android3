package com.example.homework4_android3.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework4_android3.data.repositories.CharacterRepository
import com.example.homework4_android3.models.CharacterModel
import com.example.homework4_android3.models.RickAndMortyResponse

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    private var _characterLifeData: MutableLiveData<RickAndMortyResponse<CharacterModel>> =
        MutableLiveData()
    val characterLifeData: LiveData<RickAndMortyResponse<CharacterModel>> get() = _characterLifeData

    private var _errorLifeData: MutableLiveData<String> =
        MutableLiveData()
    val errorLifeData: LiveData<String> get() = _errorLifeData

    fun fetchCharacter(
        name: String? = null,
        status: String? = null,
        species: String? = null,
        gender: String? = null,
        type: String? = null
    ) {
        characterRepository.fetchCharacters(
            onResponse = {
                _characterLifeData.value = it
            },
            onFailure = {
                _errorLifeData.value = it
            },
            name = name,
            status = status,
            species = species,
            gender = gender,
            type = type
        )
    }
}