package com.example.code_hero.domain

import com.example.code_hero.data.HeroesService
import javax.inject.Inject

class HeroesRepositoryImpl @Inject constructor(val service: HeroesService) : HeroesRepository {

    override suspend fun getCharacters() = service.getCharacters()


}