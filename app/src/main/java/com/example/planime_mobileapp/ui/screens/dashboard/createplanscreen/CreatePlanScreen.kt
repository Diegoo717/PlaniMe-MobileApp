package com.example.planime_mobileapp.ui.screens.dashboard.createplanscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.components.inputs.OwnTextField
import com.example.planime_mobileapp.ui.components.inputs.OwnDropdown
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle


@Composable
fun CreatePlanScreen(
    onNavigateToUserProfileScreen: () -> Unit, onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit, onNavigateToHomeScreen: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ultimate_background),
            contentDescription = "home_backgorund",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = "Crear Plan",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(4f, 4f),
                            blurRadius = 0f
                        )
                    ),
                    modifier = Modifier
                        .offset(x = 140.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.15f)
            ) {
                Text(
                    text = "Cuéntanos sobre ti",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(3f, 3f),
                            blurRadius = 0f
                        )
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.65f)
                    .padding(bottom = 20.dp)
            ) {
                OwnTextField("Edad", modifier = Modifier.width(350.dp))
                OwnTextField("Peso (kg)", modifier = Modifier.width(350.dp))
                OwnTextField("Altura (cm)", modifier = Modifier.width(350.dp))
                OwnDropdown(
                    "Genero",
                    listOf("Masculino", "Femenino"), modifier = Modifier.width(350.dp)
                )
                OwnDropdown(
                    "Nivel de actividad física",
                    listOf(
                        "Sedentario",
                        "Ligero (1-2 días/semana)",
                        "Moderado (3-4 días/semana)",
                        "Activo (5-6 días/semana)"
                    ),
                    modifier = Modifier.width(350.dp)
                )
                OwnDropdown(
                    "Objetivo fisico",
                    listOf("Bajar de peso", "Mantener un peso saludable", "Aumentar masa muscular"),
                    modifier = Modifier.width(350.dp)
                )
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(160.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.acept_button),
                        contentDescription = "active_button",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
            BottomNavBar(
                modifier = Modifier
                    .weight(0.1f),
                onNavigateToHomeScreen,
                onNavigateToUserProfileScreen,
                onNavigateToCreatePlanScreen,
                onNavigateToProgressScreen
            )
        }
    }
}