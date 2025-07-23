package com.example.planime_mobileapp.domain.model.user.progress

data class GetAllWeightRecordsResponse(
    val status: String? = null,
    val data: List<WeightRecord>? = null,
    val count: Int? = null
)

data class WeightRecord(
    val id: String,
    val weight: Double,
    val date: String
)
