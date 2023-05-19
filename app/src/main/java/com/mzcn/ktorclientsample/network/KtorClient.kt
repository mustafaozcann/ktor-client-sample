package com.mzcn.ktorclientsample.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {

    val httpClient = HttpClient(Android) {

        install(HttpTimeout) {
            socketTimeoutMillis = 30_000
            requestTimeoutMillis = 30_000
            connectTimeoutMillis = 30_000
        }

        install(ContentNegotiation) {
            json(json = Json {
                prettyPrint = true
                isLenient = true
            }, contentType = ContentType.Application.Json)
        }
    }
}