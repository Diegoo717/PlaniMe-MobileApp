package com.example.planime_mobileapp.domain.model.user.plans

data class CreatePlanRequest(
    val age: String,
    val gender: String,
    val weight: String,
    val height: String,
    val activityLevel: String,
    val goal: String
)
