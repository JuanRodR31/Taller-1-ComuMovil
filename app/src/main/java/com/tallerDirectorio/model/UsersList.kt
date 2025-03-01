package com.tallerDirectorio.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersList(
    val users: List<User> = emptyList()
)
