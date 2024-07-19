package com.example.fintrack.domain.model.dataModel

data class RegistrationRequest(
    val email: String,
    val password: String,
    val mobile: String,
    val userName: String
)
