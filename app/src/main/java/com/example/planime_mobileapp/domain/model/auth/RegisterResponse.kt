package com.example.planime_mobileapp.domain.model.auth

data class RegisterResponse(
    val message: String? = null,
    val status: String? = null,
    val data: UserData? = null
)

data class UserData(
    val firstName: String? = null,
    val lastName: String? = null,
    val email: String? = null,
    val password: String? = null,
    val code: String? = null
)
