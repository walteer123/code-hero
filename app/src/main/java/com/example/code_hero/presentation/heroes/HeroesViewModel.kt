package com.example.code_hero.presentation.heroes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.code_hero.data.entity.CharacterRemote
import com.example.code_hero.data.repository.HeroesRepository
import kotlinx.coroutines.launch

class HeroesViewModel @ViewModelInject constructor(private val repository: HeroesRepository) : ViewModel() {

    val characters: LiveData<List<CharacterRemote>>
        get() = _characters
    private val _characters = MutableLiveData<List<CharacterRemote>>()

    init {
        viewModelScope.launch {
            _characters.value = repository.getCharacters()
        }
    }

}
