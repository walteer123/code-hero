package com.example.code_hero.data.repository

import com.example.code_hero.data.entity.CharacterRemote

interface HeroesRepository {

    suspend fun getCharacters() : List<CharacterRemote>

}