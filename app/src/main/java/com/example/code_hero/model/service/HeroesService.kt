package com.example.code_hero.model.service

import com.example.code_hero.model.data.CharacterDataWrapper
import retrofit2.http.GET

interface HeroesService {


    @GET("characters")
    suspend fun getCharacters() : CharacterDataWrapper



}