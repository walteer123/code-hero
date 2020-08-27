package com.example.code_hero.data.service

import com.example.code_hero.data.entity.CharactersRemote
import retrofit2.http.GET

interface HeroesService {

    @GET("character")
    suspend fun getCharacters() : CharactersRemote

}
