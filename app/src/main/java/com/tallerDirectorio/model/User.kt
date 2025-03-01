package com.tallerDirectorio.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val maidenName: String,
    val email: String,
    val phone: String,
    val age: Int,
    val gender: String,
    val image: String,
    val birthDate: String,
    val address: Address
)

@Serializable
data class Address(
    val address: String,
    val city: String,
    val state: String,
    val stateCode: String,
    val postalCode: String,
    val country: String
)
