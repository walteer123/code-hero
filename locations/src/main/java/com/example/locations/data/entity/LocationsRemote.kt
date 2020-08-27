package com.example.locations.data.entity

import com.example.locations.data.entity.LocationRemote
import com.example.locations.data.entity.LocationsInfoRemote

data class LocationsRemote(val infoRemote: LocationsInfoRemote, val results: List<LocationRemote>)
