package com.mzcn.ktorclientsample.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int,
)