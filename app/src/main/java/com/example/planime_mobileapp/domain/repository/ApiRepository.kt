package com.example.planime_mobileapp.domain.repository

import com.example.planime_mobileapp.domain.model.auth.LoginRequest
import com.example.planime_mobileapp.domain.model.auth.LoginResponse
import com.example.planime_mobileapp.domain.model.common.ApiResponse
import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanRequest
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanResponse
import com.example.planime_mobileapp.domain.model.user.plans.GetPlansResponse
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.model.user.progress.GetWeightGoalResponse
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalResponse

interface ApiRepository {
    suspend fun getApiStatus(): Result<ApiResponse>
    suspend fun register(request: RegisterRequest): Result<RegisterResponse>
    suspend fun login(request: LoginRequest): Result<LoginResponse>
    suspend fun profile(token: String): Result<ProfileResponse>
    suspend fun setWeightGoal(token: String, request: SetWeightGoalRequest): Result<SetWeightGoalResponse>
    suspend fun getWeightGoal(token: String): Result<GetWeightGoalResponse>
    suspend fun createPlan(token: String, request: CreatePlanRequest): Result<CreatePlanResponse>
    suspend fun getPlans(token: String): Result<GetPlansResponse>
}