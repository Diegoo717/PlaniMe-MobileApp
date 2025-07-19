package com.example.planime_mobileapp.data.repository

import android.util.Log
import android.util.Log.e
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.remote.ApiClient
import com.example.planime_mobileapp.domain.model.auth.LoginRequest
import com.example.planime_mobileapp.domain.model.auth.LoginResponse
import com.example.planime_mobileapp.domain.model.common.ApiResponse
import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.model.user.ProfileResponse
import com.example.planime_mobileapp.domain.repository.ApiRepository

class ApiRepositoryImpl() : ApiRepository {
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

    override suspend fun login(request: LoginRequest): Result<LoginResponse> {
        return try {
            val response = ApiClient.apiService.login(request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(
                    Exception(
                        "Error al iniciar sesión: ${
                            response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun profile(token: String): Result<ProfileResponse> {
        return try {
            val response = ApiClient.apiService.profile("Bearer "+token)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(
                    Exception(
                        "Error al obtener los datos de perfil: ${
                            response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}