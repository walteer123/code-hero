package com.example.code_hero.presentation.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.code_hero.Connection
import com.example.code_hero.data.entity.Character
import com.example.code_hero.data.entity.RemoteData
import com.example.code_hero.data.entity.Response
import kotlinx.coroutines.Dispatchers


class HeroesViewModel : ViewModel() {

    private val service = Connection.heroesService
    
    val heroes: LiveData<Response<RemoteData<Character>>>
        get() = liveData(Dispatchers.IO) { emit(service.getCharacters()) }



}