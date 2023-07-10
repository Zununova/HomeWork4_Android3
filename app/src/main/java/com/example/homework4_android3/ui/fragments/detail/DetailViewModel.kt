package com.example.homework4_android3.ui.fragments.detail

import com.example.homework4_android3.base.BaseViewModel
import com.example.homework4_android3.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: CharacterRepository) :
    BaseViewModel() {

    fun fetchCharacterById(id: Int) = repository.fetchCharacterById(id)
}