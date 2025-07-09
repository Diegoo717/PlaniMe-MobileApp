package com.example.planime_mobileapp.screens.user

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
import com.example.planime_mobileapp.components.BottomNavBar
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.components.CreatePlanDropdown
import com.example.planime_mobileapp.components.CreatePlanTextField
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import java.util.Collections.list

@Composable
fun CreatePlanScreen() {
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
                Image(
                    painter = painterResource(id = R.drawable.arrow_icon),
                    contentDescription = "arrow_icon",
                    modifier = Modifier
                        .size(30.dp)
                        .offset(x = 10.dp)
                )
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
                        .offset(x = 110.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.15f)
            ){
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
                    .weight(0.75f)
                    .padding(bottom = 20.dp)
            ) {
                CreatePlanTextField("Edad")
                CreatePlanTextField("Peso (kg)")
                CreatePlanTextField("Altura (cm)")
                CreatePlanDropdown(
                    "Genero",
                    listOf("Masculino", "Femenino")
                )
                CreatePlanDropdown("Nivel de actividad física", listOf("Sedentario", "Ligero (1-2 días/semana)", "Moderado (3-4 días/semana)", "Activo (5-6 días/semana)"))
                CreatePlanDropdown(
                    "Objetivo fisico",
                    listOf("Bajar de peso", "Mantener un peso saludable", "Aumentar masa muscular")
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
                    .weight(0.1f)
            )
        }
    }
}