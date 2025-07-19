package com.example.planime_mobileapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph
import com.example.planime_mobileapp.data.local.AppPreferences
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.data.repository.ApiRepositoryImpl
import com.example.planime_mobileapp.domain.usecase.common.GetApiStatusUseCase
import com.example.planime_mobileapp.navigation.AppNavGraph
import com.example.planime_mobileapp.ui.screens.dashboard.aboutusscreen.AboutUsScreen
import com.example.planime_mobileapp.ui.screens.dashboard.progressscreen.ProgressScreen
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        testApiConnection()
        val appPreferences = AppPreferences(this)
        val tokenPreferences = TokenPreferences(this)

        setContent {
           AppNavGraph(appPreferences = appPreferences, tokenPreferences = tokenPreferences)
        }
    }
    private val repository = ApiRepositoryImpl()
    private val getApiStatusUseCase = GetApiStatusUseCase(repository)

    private fun testApiConnection() {
        lifecycleScope.launch {
            try {
                val result = getApiStatusUseCase()
                result.onSuccess { response ->
                    Log.d("API_TEST", "Conexión exitosa: $response")
                }.onFailure { error ->
                    Log.e("API_TEST", "Error en conexión: ${error.message}")
                }
            } catch (e: Exception) {
                Log.e("API_TEST", "Excepción: ${e.message}")
            }
        }
    }
}
