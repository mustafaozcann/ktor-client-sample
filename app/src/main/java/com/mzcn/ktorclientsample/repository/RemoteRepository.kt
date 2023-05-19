package com.mzcn.ktorclientsample.repository

import com.mzcn.ktorclientsample.network.dto.PostModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val client: HttpClient){

    suspend fun getPosts(): List<PostModel> =
        client.get("https://jsonplaceholder.typicode.com/posts").body()
}