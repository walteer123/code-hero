package com.example.code_hero.presentation.heroes

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.code_hero.Connection
import com.example.code_hero.data.entity.Character
import com.example.code_hero.data.entity.RemoteData
import com.example.code_hero.data.entity.Response
import com.example.code_hero.domain.HeroesRepository
import kotlinx.coroutines.launch


class HeroesViewModel @ViewModelInject constructor(private val repository: HeroesRepository) : ViewModel() {

    val characters: LiveData<Response<RemoteData<Character>>>
        get() = _characters
    private val _characters = MutableLiveData<Response<RemoteData<Character>>>()

    fun getCharactersList() {
        viewModelScope.launch {
            _characters.value = repository.getCharacters()
        }
    }


}
