package com.example.planime_mobileapp.data.local

import android.content.Context

class AppPreferences(private val context: Context) {
    private val sharedPrefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)

    fun setOnboardingCompleted() {
        sharedPrefs.edit().putBoolean("onboarding_completed", true).apply()
    }

    fun isOnboardingCompleted(): Boolean {
        return sharedPrefs.getBoolean("onboarding_completed", false)
    }
}