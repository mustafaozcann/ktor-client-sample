package com.mzcn.ktorclientsample.di

import com.mzcn.ktorclientsample.network.KtorClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesHttpClient() : HttpClient{
        return KtorClient.httpClient
    }
}