package com.example.planime_mobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.planime_mobileapp.screens.mainScreen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.planime_mobileapp.navegation.AppNavGraph
import com.example.planime_mobileapp.screens.loadingScreen
import com.example.planime_mobileapp.ui.theme.PlaniMeMobileAppTheme
import com.example.planime_mobileapp.screens.welcomeScreen
import com.example.planime_mobileapp.screens.welcomeScreenTwo
import com.example.planime_mobileapp.screens.welcomeScreenThree

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavGraph()
        }
    }
}
