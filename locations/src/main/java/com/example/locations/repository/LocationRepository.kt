package com.example.locations.repository

import com.example.locations.data.entity.LocationRemote

interface LocationRepository {

    suspend fun getLocations() : List<LocationRemote>

}
