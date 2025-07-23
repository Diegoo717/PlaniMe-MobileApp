package com.example.planime_mobileapp.domain.usecase.user.progress

import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.domain.model.user.progress.GetAllWeightRecordsResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class GetAllWeightRecords(
    private val repository: ApiRepository,
    private val tokenPreferences: TokenPreferences
) {

    val token = tokenPreferences.getToken()

    suspend operator fun  invoke(): Result<GetAllWeightRecordsResponse>{
        return try {
            val result = repository.getAllWeightRecords("Bearer $token")
            result
        } catch (e: Exception) {
            Result.failure(e)
        } ?: Result.failure(Exception("No auth token available"))
    }

}