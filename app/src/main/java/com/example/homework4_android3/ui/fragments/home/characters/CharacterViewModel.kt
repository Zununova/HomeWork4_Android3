package com.example.homework4_android3.ui.fragments.home.characters

import com.example.homework4_android3.base.BaseViewModel
import com.example.homework4_android3.data.models.QueryModel
import com.example.homework4_android3.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    BaseViewModel() {

     fun fetchCharacters(
        model: QueryModel
    ) = repository.fetchCharacters(model.name, model.status, model.species, model.type, model.gender)
    }