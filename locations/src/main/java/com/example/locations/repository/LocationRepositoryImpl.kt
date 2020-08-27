package com.example.locations.repository

import com.example.locations.data.entity.LocationRemote
import com.example.locations.data.service.LocationService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class LocationRepositoryImpl(
    private val service: LocationService,
    private val ioDispatcher: CoroutineDispatcher
): LocationRepository {

    override suspend fun getLocations() = withContext(ioDispatcher){
        service.getCharacters().results
    }
}