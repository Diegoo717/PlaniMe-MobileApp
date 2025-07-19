package com.example.planime_mobileapp.ui.screens.dashboard.progressscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.presentation.viewmodel.ProgressScreenViewModel

class ProgressViewModelFactory(
    private val tokenPreferences: TokenPreferences
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProgressScreenViewModel::class.java)) {
            return ProgressScreenViewModel(tokenPreferences) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}