package com.example.planime_mobileapp.domain.usecase.auth

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.auth.LoginRequest
import com.example.planime_mobileapp.domain.model.auth.LoginResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class LoginUseCase(
    private val repository: ApiRepository,
    private val tokenPreferences: TokenPreferences
) {

    suspend operator fun invoke(
        email: String,
        password: String
    ): Result<LoginResponse> {

        val emailError = validateEmail(email)
        if (emailError != null) {
            return Result.failure(Exception(emailError))
        }

        val passwordError = validatePassword(password)
        if (passwordError != null) {
            return Result.failure(Exception(passwordError))
        }

        val request = LoginRequest(email, password)

        return try {
            val result = repository.login(request)

            result.onSuccess { response ->
                response.token?.let { token ->
                    tokenPreferences.saveToken(token)
                }
            }

            result.onFailure { error ->
                return Result.failure(Exception("Correo u Contraseña incorrectos"))
            }

            result
        } catch (e: Exception) {
            Result.failure(Exception("Error de conexión. Intenta de nuevo"))
        }
    }

    private fun validateEmail(email: String): String? {
        val emailRegex = Regex("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")
        return when {
            email.isBlank() -> "El correo electrónico es obligatorio"
            !emailRegex.matches(email) -> "Ingresa un correo electrónico válido"
            else -> null
        }
    }

    private fun validatePassword(password: String): String? {
        return when {
            password.isBlank() -> "La contraseña es obligatoria"
            password.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
            !password.contains(Regex("[A-Z]")) -> "La contraseña debe contener al menos una mayúscula"
            !password.contains(Regex("[0-9]")) -> "La contraseña debe contener al menos un número"
            !password.contains(Regex("[!@#\$%^&*(),.?\":{}|<>]")) -> "La contraseña debe contener al menos un carácter especial"
            else -> null
        }
    }

}