package com.example.planime_mobileapp.domain.usecase.user.progress

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.model.user.progress.setWeightGoalRequest
import com.example.planime_mobileapp.domain.model.user.progress.setWeightGoalResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class setWeightGoalUseCase(
    private val repository: ApiRepository,
    tokenPreferences: TokenPreferences
) {
    val token = tokenPreferences.getToken()

    suspend operator fun invoke(weight: String): Result<setWeightGoalResponse> {
        return try {
            val request = setWeightGoalRequest(weight)
            val result = repository.setWeightGoal("$token", request)
            result
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}