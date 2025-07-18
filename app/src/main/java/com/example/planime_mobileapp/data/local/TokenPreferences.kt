package com.example.planime_mobileapp.data.local

import android.content.Context

class TokenPreferences(private val context: Context) {

    private val sharedPrefs = context.getSharedPreferences("token_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPrefs.edit()
            .putString("access_token", token)
            .apply()
    }

    fun getToken(): String? {
        return sharedPrefs.getString("access_token", null)
    }

    fun clearToken() {
        sharedPrefs.edit()
            .remove("access_token")
            .apply()
    }

    fun hasToken(): Boolean {
        return !getToken().isNullOrEmpty()
    }
}