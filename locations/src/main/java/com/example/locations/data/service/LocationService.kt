package com.example.locations.data.service

import com.example.locations.data.entity.LocationsRemote
import retrofit2.http.GET

interface LocationService {

    @GET("location")
    suspend fun getCharacters() : LocationsRemote
}