package com.example.planime_mobileapp.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        .weight(0.2f)
                        .background(color = Color.Red),
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
                        .weight(0.5f)
                        .background(color = Color.Blue),
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
                        .background(color = Color.Green)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(color = Color.Yellow)
                            .width(100.dp)
                            .height(80.dp)
                            .border(2.dp, color = Color(0xFFFF6B6B))
                    ) {
                        Text(
                            text = "15",
                            style = TextStyle(
                                fontSize = 32.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(text = "Planes")
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(color = Color.Yellow)
                            .width(100.dp)
                            .height(80.dp)
                            .border(2.dp, color = Color(0xFFFF6B6B))
                    ) {
                        Text(
                            text = "10",
                            style = TextStyle(
                                fontSize = 32.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(text = "Objetivos")
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .background(color = Color.Yellow)
                            .width(100.dp)
                            .height(80.dp)
                            .border(2.dp, color = Color(0xFFFF6B6B))
                    ) {
                        Text(
                            text = "1",
                            style = TextStyle(
                                fontSize = 32.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(text = "Insignias")
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.45f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.2f)
                        .background(color = Color.Cyan)
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
                        .background(color = Color.DarkGray)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .background(color = Color.Red)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = Color.Red)
                        ){
                            Text(
                                text = "Edad",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Text(
                                text = "22",
                                color = Color.Gray,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = Color.Blue)
                        ){
                            Text(
                                text = "Correo Electronico",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Text(
                                text = "soydiegoo@gmail.com",
                                color = Color.Gray,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = Color.Blue)
                        ){
                            Text(
                                text = "Peso",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Text(
                                text = "77",
                                color = Color.Gray,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.5f)
                                .fillMaxHeight()
                                .background(color = Color.Red)
                        ){
                            Text(
                                text = "Altura",
                                style = TextStyle(
                                    fontSize = 26.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                            Text(
                                text = "1.73",
                                color = Color.Gray,
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                )
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f)
                        .background(color = Color.Magenta)
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(160.dp)
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFFF6B6B))
                    .weight(0.1f)
                    .drawBehind {
                        drawRect(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Black.copy(alpha = 0.1f),
                                    Color.Transparent
                                ),
                                startY = 0f,
                                endY = 30f
                            ),
                            size = Size(size.width, 15.dp.toPx())
                        )
                    },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_icon),
                    contentDescription = "home_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(45.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "add_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(45.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.goals_icon),
                    contentDescription = "goals_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(45.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "user_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(45.dp)
                )
            }
        }

    }
}