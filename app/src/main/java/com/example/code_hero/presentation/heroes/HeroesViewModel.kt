package com.example.code_hero.presentation.heroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.code_hero.Connection
import kotlinx.coroutines.Dispatchers


class HeroesViewModel: ViewModel() {

    private val service = Connection.heroesService

    //suspend fun getCharacters = service.getCharacters()
    fun getHeroes() = liveData(Dispatchers.IO){
        val result = service.getCharacters()
        emit(result)
    }

}