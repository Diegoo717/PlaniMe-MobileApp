package com.example.planime_mobileapp.ui.screens.dashboard.detailsplan

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.planime_mobileapp.data.local.TokenPreferences

class DetailsPlanViewModelFactory(
    private val tokenPreferences: TokenPreferences,
    private val planId: Int,
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsPlanViewModel(
            tokenPreferences = tokenPreferences,
            planId = planId,
            context = context
        ) as T
    }
}