package com.mzcn.ktorclientsample.repository

import com.mzcn.ktorclientsample.network.model.Comment
import com.mzcn.ktorclientsample.network.model.Post
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class RemoteRepository(private val client: HttpClient) {

    suspend fun getPosts(): List<Post> =
        client.get(HttpRoutes.POSTS).body()

    suspend fun getComments(): List<Comment> =
        client.get(HttpRoutes.COMMENTS).body()


    suspend fun postPost(post: Post): Post = client.post {
        url(HttpRoutes.POSTS)
        contentType(ContentType.Application.Json)
        body = Json.encodeToString(post)
    }.body()

}