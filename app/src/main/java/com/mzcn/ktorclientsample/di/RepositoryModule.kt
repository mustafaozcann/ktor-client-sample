package com.mzcn.ktorclientsample.di

import com.mzcn.ktorclientsample.repository.RemoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Inject


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesRemoteRepo(client: HttpClient) : RemoteRepository{
        return RemoteRepository(client)
    }
}