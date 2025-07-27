package com.example.planime_mobileapp.data.repository

import com.example.planime_mobileapp.data.remote.ApiClient
import com.example.planime_mobileapp.domain.model.auth.LoginRequest
import com.example.planime_mobileapp.domain.model.auth.LoginResponse
import com.example.planime_mobileapp.domain.model.common.ApiResponse
import com.example.planime_mobileapp.domain.model.auth.RegisterRequest
import com.example.planime_mobileapp.domain.model.auth.RegisterResponse
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanRequest
import com.example.planime_mobileapp.domain.model.user.plans.CreatePlanResponse
import com.example.planime_mobileapp.domain.model.user.plans.DeletePlanResponse
import com.example.planime_mobileapp.domain.model.user.plans.GetPlansResponse
import com.example.planime_mobileapp.domain.model.user.profile.ProfileResponse
import com.example.planime_mobileapp.domain.model.user.progress.GetAllWeightRecordsResponse
import com.example.planime_mobileapp.domain.model.user.progress.GetWeightGoalResponse
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightGoalResponse
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordRequest
import com.example.planime_mobileapp.domain.model.user.progress.SetWeightRecordResponse
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
            val response = ApiClient.apiService.profile(token)
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

    override suspend fun setWeightGoal(token: String, request: SetWeightGoalRequest): Result<SetWeightGoalResponse> {
        return try {
            val response = ApiClient.apiService.setWeightGoal(token, request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(
                    Exception(
                        "Error al insertar los datos de objetivo: ${
                            response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getWeightGoal(token: String): Result<GetWeightGoalResponse> {
        return try{
            val response = ApiClient.apiService.getWeightGoal(token)
            if(response.isSuccessful){
                response.body()?.let{
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            }else{
                Result.failure(
                    Exception("Error al obtener los datos de objetivo: ${response.code()}"))
            }
        }catch(e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun createPlan(token: String, request: CreatePlanRequest): Result<CreatePlanResponse>{
        return try{
            val response = ApiClient.apiService.createPlan(token, request)
            if(response.isSuccessful){
                response.body()?.let{
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            }else{
                Result.failure(
                    Exception("Error al generar plan:  ${response.code()}")
                )
            }
        }catch (e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getPlans(token: String): Result<GetPlansResponse> {
        return try{
            val response = ApiClient.apiService.getPlans(token)
            if(response.isSuccessful){
                response.body()?.let{
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            }else{
                Result.failure(
                    Exception("Error al obtener los planes: ${response.code()}"))
            }
        }catch(e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun setWeightRecord(token: String, request: SetWeightRecordRequest): Result<SetWeightRecordResponse> {
        return try {
            val response = ApiClient.apiService.setWeightRecord(token, request)
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            } else {
                Result.failure(
                    Exception(
                        "Error al insertar registro de peso: ${
                            response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getAllWeightRecords(token: String): Result<GetAllWeightRecordsResponse> {
        return try{
            val response = ApiClient.apiService.getAllWeightRecords(token)
            if(response.isSuccessful){
                response.body()?.let{
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            }else{
                Result.failure(
                    Exception("Error al obtener los registros de peso: ${response.code()}"))
            }
        }catch(e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun deletePlan(planId: Int, token: String): Result<DeletePlanResponse> {
        return try{
            val response = ApiClient.apiService.deletePlan(planId, token)
            if(response.isSuccessful){
                response.body()?.let{
                    Result.success(it)
                } ?: Result.failure(Exception("Respuesta vacía"))
            }else{
                Result.failure(
                    Exception("Error al eliminar el plan: ${response.code()}"))
            }
        }catch(e: Exception){
            Result.failure(e)
        }
    }
}