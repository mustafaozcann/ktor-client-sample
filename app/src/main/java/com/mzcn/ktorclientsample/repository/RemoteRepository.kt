package com.mzcn.ktorclientsample.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val client: HttpClient){

    suspend fun getPosts(): HttpResponse =
        client.get("https://jsonplaceholder.typicode.com/posts")
}