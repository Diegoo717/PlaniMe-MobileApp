package com.example.planime_mobileapp.domain.usecase

import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class RegisterUseCase(
    private val repository: ApiRepository
) {
    suspend operator fun invoke(
        firstName: String,
        lastName: String,
        email: String,
        password: String
    ): Result<RegisterResponse> {

        val firstNameError = validateFirstName(firstName)
        if (firstNameError != null) {
            return Result.failure(Exception(firstNameError))
        }

        val lastNameError = validateLastName(lastName)
        if (lastNameError != null) {
            return Result.failure(Exception(lastNameError))
        }

        val emailError = validateEmail(email)
        if (emailError != null) {
            return Result.failure(Exception(emailError))
        }

        val passwordError = validatePassword(password)
        if (passwordError != null) {
            return Result.failure(Exception(passwordError))
        }

        val request = RegisterRequest(
            firstName = firstName,
            lastName = lastName,
            email = email,
            password = password
        )

        return repository.register(request)
    }

    private fun validateFirstName(firstName: String): String? {
        return when {
            firstName.isBlank() -> "El nombre es obligatorio"
            firstName.length < 3 -> "El nombre debe tener al menos 3 caracteres"
            !firstName.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) -> "Solo se permiten letras y espacios"
            else -> null
        }
    }

    private fun validateLastName(lastName: String): String? {
        return when {
            lastName.isBlank() -> "Los apellidos son obligatorios"
            lastName.length < 3 -> "Los apellidos deben tener al menos 3 caracteres"
            !lastName.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$")) -> "Solo se permiten letras y espacios"
            else -> null
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