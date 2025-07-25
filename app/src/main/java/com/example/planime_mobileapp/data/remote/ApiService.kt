package com.example.planime_mobileapp.data.remote

import com.example.planime_mobileapp.domain.model.auth.LoginRequest
import com.example.planime_mobileapp.domain.model.auth.LoginResponse
import com.example.planime_mobileapp.domain.model.common.ApiResponse
import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanRequest
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanResponse
import com.example.planime_mobileapp.domain.model.user.plans.GetPlansResponse
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.model.user.progress.GetAllWeightRecordsResponse
import com.example.planime_mobileapp.domain.model.user.progress.GetWeightGoalResponse
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalResponse
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    @GET("/")
    suspend fun getApiStatus(): Response<ApiResponse>

    @POST("/api/register")
    suspend fun register(@Body request: RegisterRequest): Response<RegisterResponse>

    @POST("/api/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @Headers("Content-Type: application/json")
    @GET("/api/protected/profile")
    suspend fun profile(@Header("Authorization") token: String): Response<ProfileResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/protected/setWeightGoal")
    suspend fun setWeightGoal(@Header("Authorization") token: String, @Body request: SetWeightGoalRequest): Response<SetWeightGoalResponse>

    @Headers("Content-Type: application/json")
    @GET("/api/protected/getWeightGoal")
    suspend fun getWeightGoal(@Header("Authorization") token: String): Response<GetWeightGoalResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/protected/generatePlan")
    suspend fun createPlan(@Header("Authorization") token: String, @Body request: CreatePlanRequest): Response<CreatePlanResponse>

    @Headers("Content-Type: application/json")
    @GET("/api/protected/getPlansByID")
    suspend fun getPlans(@Header("Authorization") token: String): Response<GetPlansResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/protected/setWeightRecord")
    suspend fun setWeightRecord(@Header("Authorization") token: String, @Body request: SetWeightRecordRequest): Response<SetWeightRecordResponse>

    @Headers("Content-Type: application/json")
    @GET("/api/protected/getAllWeightR")
    suspend fun getAllWeightRecords(@Header("Authorization") token: String): Response<GetAllWeightRecordsResponse>
}