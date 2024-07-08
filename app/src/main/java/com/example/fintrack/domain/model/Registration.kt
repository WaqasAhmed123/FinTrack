package com.example.fintrack.domain.model

data class Registration(
    val email: String,
    val mobile: String,
    val token: Any,
    val userId: String,
    val userName: String
)