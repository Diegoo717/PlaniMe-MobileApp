package com.example.planime_mobileapp.data.remote

import com.example.planime_mobileapp.domain.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    suspend fun getApiStatus(): Response<ApiResponse>
}