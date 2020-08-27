package com.example.code_hero.data.repository

import com.example.code_hero.data.HeroesService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class HeroesRepositoryImpl(
    private val service: HeroesService,
    private val ioDispatcher: CoroutineDispatcher
) : HeroesRepository {

    override suspend fun getCharacters() = withContext(ioDispatcher) {
        service.getCharacters().results
    }

}
