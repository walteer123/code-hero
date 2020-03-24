package com.example.code_hero.ui.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.code_hero.model.Connection
import com.example.code_hero.model.data.CharacterDataWrapper
import kotlinx.coroutines.Dispatchers


class HeroesViewModel: ViewModel() {

    private val service = Connection.heroesService

    //suspend fun getCharacters = service.getCharacters()
    fun getHeroes() = liveData(Dispatchers.IO){
        val result = service.getCharacters()
        emit(result)
    }

}