package com.example.code_hero.data

import com.example.code_hero.data.entity.Character
import com.example.code_hero.data.entity.RemoteData
import com.example.code_hero.data.entity.Response
import retrofit2.http.GET

interface HeroesService {


    @GET("characters")
    suspend fun getCharacters() : Response<RemoteData<Character>>



}