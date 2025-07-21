package com.example.planime_mobileapp.domain.usecase.user.progress

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class SetWeightGoalUseCase(
    private val repository: ApiRepository,
    tokenPreferences: TokenPreferences
) {
    val token = tokenPreferences.getToken()

    suspend operator fun invoke(weight: String): Result<SetWeightGoalResponse> {
        return try {
            val request = SetWeightGoalRequest(weight)
            val result = repository.setWeightGoal("$token", request)
            result
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}