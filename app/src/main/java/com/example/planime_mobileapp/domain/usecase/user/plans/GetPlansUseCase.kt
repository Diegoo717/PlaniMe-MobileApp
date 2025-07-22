package com.example.planime_mobileapp.domain.usecase.user.plans

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.plans.GetPlansResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class GetPlansUseCase(
    private val repository: ApiRepository,
    private val tokenPreferences: TokenPreferences
) {

    val token = tokenPreferences.getToken()

    suspend operator fun  invoke(): Result<GetPlansResponse>{
        return try {
            val result = repository.getPlans("Bearer $token")
            result
        } catch (e: Exception) {
            Result.failure(e)
        } ?: Result.failure(Exception("No auth token available"))
    }
}