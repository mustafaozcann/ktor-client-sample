package com.mzcn.ktorclientsample.network

import com.mzcn.ktorclientsample.repository.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {

    val httpClient = HttpClient(Android) {

        install(HttpTimeout) {
            socketTimeoutMillis = 10_000
            requestTimeoutMillis = 10_000
            connectTimeoutMillis = 10_000
        }

        install(ContentNegotiation) {

            json(json = Json {
                prettyPrint = true
                isLenient = true
            }, contentType = ContentType.Application.Json)
        }

        defaultRequest {
            host = HttpRoutes.BASE_URL

            url{
                protocol = URLProtocol.HTTPS
            }
        }
    }
}