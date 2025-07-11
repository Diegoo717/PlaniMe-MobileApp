package com.example.planime_mobileapp.ui.screens.dashboard.aboutusscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions

@Composable
fun AboutUsScreen(onNavigateToUserProfileScreen: () -> Unit) {
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
        AnimatedScreen(
            enter = ScreenTransitions.enterFromTop,
            exit = ScreenTransitions.exitToBottom
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                        .weight(0.1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_icon),
                        contentDescription = "arrow_icon",
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 10.dp)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = ripple(bounded = false, radius = 30.dp),
                                onClick = { onNavigateToUserProfileScreen() }
                            )
                    )
                    Text(
                        text = "Sobre Nosotros",
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
                            .offset(x = 90.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.4f)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 5.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 4.dp,
                                color = Color(0xFFFF6B6B),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.1f)
                        ) {
                            Text(
                                text = "PlaniMe",
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
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .weight(0.9f)
                        ) {
                            Text(
                                text = "Misión",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            )
                            Text(
                                text = "Empoderarte para lograr tus metas de salud con planes nutricionales personalizados y accesibles.",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                ),
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "Visión",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            )
                            Text(
                                text = "Revolucionar la nutrición combinando tecnología móvil/web y ciencia.",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                ),
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "Valores",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            )
                            Text(
                                text = "✓ Personalización - Planes 100% adaptados a ti\n" +
                                        "✓ Adaptabilidad - Mejora continua basada en tu progreso\n" +
                                        "✓ Simplicidad - Experiencia intuitiva y sin complicaciones",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                ),
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 20.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .border(
                                width = 4.dp,
                                color = Color(0xFFA0D94A),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(20.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .weight(0.1f)
                        ) {
                            Text(
                                text = "Información Tecnica",
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
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier
                                .weight(0.9f)
                        ) {
                            Text(
                                text = "Tecnología de la app",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 20.dp)
                            )
                            Text(
                                text = "▸ Arquitectura: MVVM + Clean Architecture\n" +
                                        "▸ UI Nativa: Jetpack Compose (Material Design 3)\n" +
                                        "▸ Gestión de Datos: Conexión directa con API REST\n   utilizando Retrofit\n" +
                                        "▸ Corrutinas para operaciones asíncronas\n" +
                                        "▸ Seguridad: Autenticación JWT + Encriptación AES",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                ),
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                            Text(
                                text = "Desarrollador",
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                    fontWeight = FontWeight.Bold
                                ),
                                modifier = Modifier
                                    .padding(top = 15.dp)
                            )
                            Text(
                                text = "Ing. Diego Magaña Álvarez\n" +
                                        "▸ Rol: Arquitecto principal y desarrollador Full-Stack\n" +
                                        "▸ Experiencia: 2+ años en desarrollo móvil/web y sistemas escalables\n" +
                                        "▸ Contacto: soydiegoo71@gmail.com\n",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Justify,
                                ),
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}