package com.example.planime_mobileapp.domain.usecase.user.progress

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.repository.ApiRepository

class GetWeightGoalUseCase(
    private val repository: ApiRepository,
    private val tokenPreferences: TokenPreferences
    ) {

    val token = tokenPreferences.getToken()

    suspend operator fun invoke() = repository.getWeightGoal("Bearer $token")
}