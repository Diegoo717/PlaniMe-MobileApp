package com.example.planime_mobileapp.domain.model.user.plans

import com.google.gson.annotations.SerializedName

data class GetPlansResponse(
    @SerializedName("success")
    val success: Boolean,

    @SerializedName("plans")
    val plans: List<Plan>? = null,

    @SerializedName("error")
    val error: String? = null,

    @SerializedName("details")
    val details: String? = null
)

data class Plan(
    @SerializedName("name")
    val name: String,

    @SerializedName("imageUrl")
    val imageUrl: String,

    @SerializedName("details")
    val details: PlanDetails
)

data class PlanDetails(
    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("age")
    val age: Int,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("weight")
    val weight: Double,

    @SerializedName("height")
    val height: Double,

    @SerializedName("activityLevel")
    val activityLevel: String,

    @SerializedName("goal")
    val goal: String,

    @SerializedName("imc")
    val imc: Double,

    @SerializedName("planName")
    val planName: String,

    @SerializedName("planImagePath")
    val planImagePath: String,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("updatedAt")
    val updatedAt: String
)