package com.example.locations.di

import com.example.locations.data.service.LocationService
import com.example.locations.repository.LocationRepository
import com.example.locations.repository.LocationRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LocationServiceModule {
    @Singleton
    @Provides
    fun provideLocationService(retrofit: Retrofit) = retrofit.create(LocationService::class.java)
}

@Module
@InstallIn(ApplicationComponent::class)
object LocationRepositoryModule {
    @Singleton
    @Provides
    fun provideLocationRepository(service: LocationService, ioDispatcher: CoroutineDispatcher): LocationRepository {
        return LocationRepositoryImpl(service, ioDispatcher)
    }
}