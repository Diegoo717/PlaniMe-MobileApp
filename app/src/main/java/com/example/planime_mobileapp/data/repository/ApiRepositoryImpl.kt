package com.example.planime_mobileapp.data.repository

import com.example.planime_mobileapp.data.remote.ApiClient
import com.example.planime_mobileapp.domain.model.common.ApiResponse
import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class ApiRepositoryImpl : ApiRepository {
    override suspend fun getApiStatus(): Result<ApiResponse> {
        return try {
            val response = ApiClient.apiService.getApiStatus()
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(Exception("Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    override suspend fun register(request: RegisterRequest): Result<RegisterResponse> {
        return try {
            val response = ApiClient.apiService.register(request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(Exception("Error al registrar: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}