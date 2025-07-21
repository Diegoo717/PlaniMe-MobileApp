package com.example.planime_mobileapp.domain.usecase.user.plans

import android.util.Log
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanRequest
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class CreatePlanUseCase(
    private val repository: ApiRepository,
    tokenPreferences: TokenPreferences
) {

    val token = tokenPreferences.getToken()

    suspend operator fun invoke(
        age: String,
        gender: String,
        weight: String,
        height: String,
        activityLevel: String,
        goal: String
    ): Result<CreatePlanResponse>{

        val ageError = validateAge(age)
        if (ageError != null) {
            return Result.failure(Exception(ageError))
        }

        val genderError = validateGender(gender)
        if (genderError != null) {
            return Result.failure(Exception(genderError))
        }

        val weightError = validateWeight(weight)
        if (weightError != null) {
            return Result.failure(Exception(weightError))
        }

        val heightError = validateHeight(height)
        if (heightError != null) {
            return Result.failure(Exception(heightError))
        }

        val activityLevelError = validateActivityLevel(activityLevel)
        if (activityLevelError != null) {
            return Result.failure(Exception(activityLevelError))
        }

        val goalError = validateGoal(goal)
        if (goalError != null) {
            return Result.failure(Exception(goalError))
        }

        val normalizedActivityLevel = normalizeActivityLevel(activityLevel)
        val normalizedGoal = normalizeGoal(goal)
        val normalizedGender = normalizeGender(gender)

        val request = CreatePlanRequest(
            age = age,
            gender = normalizedGender,
            weight = weight,
            height = height,
            activityLevel = normalizedActivityLevel,
            goal = normalizedGoal
        )

        Log.d("TAG", "Original request: age=$age, gender=$gender, weight=$weight, height=$height, activityLevel=$activityLevel, goal=$goal")
        Log.d("TAG", "Normalized request: $request")

        return try{
            repository.createPlan(token?:"", request).fold(
                onSuccess = { response ->
                    Log.d("TAG",response.toString())
                    Result.success(response)
                },
                onFailure = { response ->
                    Result.failure(response)
                }
            )
        }catch(e: Exception){
            Result.failure(Exception("Error de conexión. Intenta de nuevo"))
        }
    }

    private fun normalizeActivityLevel(activityLevel: String): String {
        return when (activityLevel.lowercase()) {
            "sedentario", "sedentario (poco o nada de ejercicio)" -> "sedentario"
            "ligero", "Ligero (1-2 días/semana)" -> "ligero"
            "moderado", "Moderado (3-4 días/semana)" -> "moderado"
            "activo", "Activo (5-6 días/semana)", -> "activo"
            else -> "moderado"
        }
    }

    private fun normalizeGoal(goal: String): String {
        return when (goal.lowercase()) {
            "bajar de peso", "perder peso", "perder" -> "perder"
            "mantener un peso saludable", "mantener" -> "mantener"
            "aumentar masa muscular", "aumentar" -> "aumentar"
            else -> "mantener"
        }
    }

    private fun normalizeGender(gender: String): String {
        return when (gender.lowercase()) {
            "masculino", "hombre", "male" -> "m"
            "femenino", "mujer", "female" -> "f"
            else -> gender.lowercase()
        }
    }

    private fun validateAge(age: String): String? {
        return when {
            age.isBlank() -> "La edad es obligatoria"
            !age.matches(Regex("^[0-9]+$")) -> "La edad debe contener solo números"
            age.toIntOrNull() == null -> "Ingresa una edad válida"
            age.toInt() < 12 || age.toInt() > 99 -> "La edad debe estar entre 12 y 99 años"
            else -> null
        }
    }

    private fun validateGender(gender: String): String? {
        return when {
            gender.isBlank() -> "Debes seleccionar tu sexo"
            else -> null
        }
    }

    private fun validateWeight(weight: String): String? {
        return when {
            weight.isBlank() -> "El peso es obligatorio"
            !weight.matches(Regex("^[0-9]+(\\.[0-9]+)?$")) -> "El peso debe ser un número válido"
            weight.toDoubleOrNull() == null -> "Ingresa un peso válido"
            weight.toDouble() < 30 || weight.toDouble() > 200 -> "El peso debe estar entre 30 y 200 kg"
            else -> null
        }
    }

    private fun validateHeight(height: String): String? {
        return when {
            height.isBlank() -> "La altura es obligatoria"
            !height.matches(Regex("^[0-9]+(\\.[0-9]+)?$")) -> "La altura debe ser un número válido"
            height.toDoubleOrNull() == null -> "Ingresa una altura válida"
            height.toDouble() < 120 || height.toDouble() > 250 -> "La altura debe estar entre 120 y 250 cm"
            else -> null
        }
    }

    private fun validateActivityLevel(activityLevel: String): String? {
        return when {
            activityLevel.isBlank() -> "Debes seleccionar tu nivel de actividad"
            else -> null
        }
    }

    private fun validateGoal(goal: String): String? {
        return when {
            goal.isBlank() -> "Debes seleccionar tu objetivo físico"
            else -> null
        }
    }
}