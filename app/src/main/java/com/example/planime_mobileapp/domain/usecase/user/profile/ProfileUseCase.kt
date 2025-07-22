package com.example.planime_mobileapp.domain.usecase.user.profile

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class ProfileUseCase(
    private val repository: ApiRepository,
    tokenPreferences: TokenPreferences
) {
    val token = tokenPreferences.getToken()

    suspend operator fun invoke(): Result<ProfileResponse> {
        return try {
            val result = repository.profile("Bearer $token")
            result
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}