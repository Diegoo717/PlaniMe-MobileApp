package com.example.planime_mobileapp.domain.repository

import com.example.planime_mobileapp.domain.model.ApiResponse

interface ApiRepository {
    suspend fun getApiStatus(): Result<ApiResponse>
}