package com.example.planime_mobileapp.domain.model.user

data class WeightOption(
    val value: Int,
    val displayText: String
) {
    companion object {
        fun generateWeightOptions(): List<WeightOption> {
            return (40..120).map { weight ->
                WeightOption(
                    value = weight,
                    displayText = "$weight kg"
                )
            }
        }
    }
}