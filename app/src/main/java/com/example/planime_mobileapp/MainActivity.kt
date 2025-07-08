package com.example.planime_mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.planime_mobileapp.navegation.AppNavGraph
import com.example.planime_mobileapp.screens.user.HomeScreen
import com.example.planime_mobileapp.screens.user.UserProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserProfileScreen()
        }
    }
}
