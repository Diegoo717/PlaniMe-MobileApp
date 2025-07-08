package com.example.planime_mobileapp.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import com.example.planime_mobileapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.components.BottomNavBar
import com.example.planime_mobileapp.components.DataBox
import com.example.planime_mobileapp.components.StatsBox
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun UserProfileScreen() {
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
        Text(text = "Próximamente!",
            modifier = Modifier
                .offset(x = 135.dp, y = -155.dp),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
                color = Color.Red,
                shadow = Shadow(
                    color = Color.White,
                    offset = Offset(4f, 4f),
                    blurRadius = 0f
                )
            ),
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .weight(0.45f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = "arrow_icon",
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 10.dp)
                    )
                    Text(
                        text = "Perfil",
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
                    Image(
                        painter = painterResource(id = R.drawable.info_icon),
                        contentDescription = "arrow_icon",
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 220.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.logout_button_icon),
                        contentDescription = "arrow_icon",
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 240.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_image),
                        contentDescription = "user_image",
                        modifier = Modifier
                            .size(100.dp)
                    )
                    Text(
                        text = "Luis Gonzales",
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
                    Text(
                        text = "Ingresó en 2025",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 18.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            shadow = Shadow(
                                color = Color.White,
                                offset = Offset(2f, 2f),
                                blurRadius = 0f
                            )
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                ) {
                    StatsBox("15","Planes")
                    StatsBox("10", "Objetivos")
                    StatsBox("1", "Insignias")
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.45f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "Datos de usuario",
                        style = TextStyle(
                            fontSize = 34.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    ) {
                        DataBox(modifier = Modifier.weight(0.5f), "Rol", "Estudiante",)
                        DataBox(modifier = Modifier.weight(0.5f), "Ciudad", "Uriangato",)
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    ) {
                        DataBox(modifier = Modifier.weight(0.5f), "Edad", "22",)
                        DataBox(modifier = Modifier.weight(0.5f), "Correo", "...o71@gmail.com",)
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(150.dp)
                            .padding(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.edit_button_icon),
                            contentDescription = "active_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            BottomNavBar(modifier = Modifier
                .weight(0.1f)
            )
        }

    }
}