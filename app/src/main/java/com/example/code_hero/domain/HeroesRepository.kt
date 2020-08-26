package com.example.code_hero.domain

import com.example.code_hero.data.entity.Character
import com.example.code_hero.data.entity.RemoteData
import com.example.code_hero.data.entity.Response

interface HeroesRepository {

    suspend fun getCharacters() : Response<RemoteData<Character>>

}
