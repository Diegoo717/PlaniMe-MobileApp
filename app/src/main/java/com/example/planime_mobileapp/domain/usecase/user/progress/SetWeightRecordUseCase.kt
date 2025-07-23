package com.example.planime_mobileapp.domain.usecase.user.progress

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class SetWeightRecordUseCase(
    private val repository: ApiRepository,
    private val tokenPreferences: TokenPreferences
) {

    val token = tokenPreferences.getToken()

    suspend operator fun invoke(
        weight: String,
        date: String
    ): Result<SetWeightRecordResponse> {

        val weightError = validateWeight(weight)
        if (weightError != null) {
            return Result.failure(Exception(weightError))
        }

        val dateError = validateDate(date)
        if (dateError != null) {
            return Result.failure(Exception(dateError))
        }

        return try {
            val formattedDate = transformDateFormat(date)
            val request = SetWeightRecordRequest(weight.trim(), formattedDate)

            repository.setWeightRecord("Bearer " + (token ?: ""), request).fold(
                onSuccess = { response ->
                    Result.success(response)
                },
                onFailure = { error ->
                    Result.failure(error)
                }
            )
        } catch (e: Exception) {
            Result.failure(Exception("Error de conexión. Intenta de nuevo"))
        }
    }

    private fun validateWeight(weightStr: String): String? {
        return when {
            weightStr.isBlank() -> "El peso es obligatorio"
            !weightStr.trim().matches(Regex("^[0-9]+(\\.[0-9]+)?$")) -> "El peso debe ser un número válido"
            weightStr.trim().toDoubleOrNull() == null -> "Ingresa un peso válido"
            weightStr.trim().toDouble() < 40.0 -> "El peso mínimo es 40 kg"
            weightStr.trim().toDouble() > 200.0 -> "El peso máximo es 200 kg"
            weightStr.trim().contains(".") && weightStr.trim().substringAfter('.').length > 2 -> "El peso no puede tener más de 2 decimales"
            else -> null
        }
    }

    private fun validateDate(dateStr: String): String? {
        return when {
            dateStr.isBlank() -> "La fecha es obligatoria"
            !dateStr.matches(Regex("^\\d{1,2}/\\d{1,2}/\\d{4}$")) -> "Formato de fecha inválido. Use dd/MM/yyyy"
            else -> {
                try {
                    val dateParts = dateStr.split("/")
                    val day = dateParts[0].toIntOrNull() ?: return "Día inválido"
                    val month = dateParts[1].toIntOrNull() ?: return "Mes inválido"
                    val year = dateParts[2].toIntOrNull() ?: return "Año inválido"

                    when {
                        day < 1 || day > 31 -> "Día debe estar entre 1 y 31"
                        month < 1 || month > 12 -> "Mes debe estar entre 1 y 12"
                        year < 1900 || year > 2100 -> "Año debe estar entre 1900 y 2100"
                        else -> null
                    }
                } catch (e: Exception) {
                    "Formato de fecha inválido. Use dd/MM/yyyy"
                }
            }
        }
    }

    private fun transformDateFormat(inputDate: String): String {
        val dateParts = inputDate.split("/")
        val day = dateParts[0].padStart(2, '0')
        val month = dateParts[1].padStart(2, '0')
        val year = dateParts[2]

        return "$year-$month-$day"
    }
}