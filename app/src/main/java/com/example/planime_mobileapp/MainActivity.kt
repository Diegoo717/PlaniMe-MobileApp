package com.example.planime_mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.planime_mobileapp.navegation.AppNavGraph
import com.example.planime_mobileapp.screens.LoadingScreen
import com.example.planime_mobileapp.screens.LoginScreen
import com.example.planime_mobileapp.screens.RegisterScreen
import com.example.planime_mobileapp.screens.MainScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RegisterScreen()
        }
    }
}
