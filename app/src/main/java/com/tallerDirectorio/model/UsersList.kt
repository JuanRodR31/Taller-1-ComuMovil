package com.tallerDirectorio.model

import kotlinx.serialization.Serializable

@Serializable
data class UsersList(
    val total: Int,
    val result: List<User>
)