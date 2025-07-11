package com.example.planime_mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavGraph
import com.example.planime_mobileapp.navigation.AppNavGraph
import com.example.planime_mobileapp.ui.screens.dashboard.aboutusscreen.AboutUsScreen
import com.example.planime_mobileapp.ui.screens.dashboard.progressscreen.ProgressScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AboutUsScreen()
        }
    }
}
