package com.example.planime_mobileapp.ui.screens.dashboard.createplanscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.planime_mobileapp.data.local.TokenPreferences

class CreatePlanViewModelFactory(
    private val tokenPreferences: TokenPreferences
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreatePlanViewModel::class.java)) {
            return CreatePlanViewModel(tokenPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}