package com.example.planime_mobileapp.domain.model.user.progress

data class SetWeightGoalResponse(
    val status: String? = null,
    val message: String? = null,
    val data: WeightGoalData
)

data class WeightGoalData(
    val id: Int,
    val userId: Int,
    val weightGoal: Int
)
