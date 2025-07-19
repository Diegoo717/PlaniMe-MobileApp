package com.example.planime_mobileapp.domain.usecase.user.profile

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class ProfileUseCase(
    private val repository: ApiRepository,
    tokenPreferences: TokenPreferences
) {
    companion object {
        private const val TAG = "ProfileUseCase"
    }

    val token = tokenPreferences.getToken()

    suspend operator fun invoke(): Result<ProfileResponse> {
        return try {
            val result = repository.profile("$token")
            result
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}