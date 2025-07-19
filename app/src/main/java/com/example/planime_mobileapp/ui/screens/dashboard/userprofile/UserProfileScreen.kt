package com.example.planime_mobileapp.ui.screens.dashboard.userprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.remember
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import com.example.planime_mobileapp.ui.components.visual.DataBox
import com.example.planime_mobileapp.ui.components.visual.StatsBox
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions

@Composable
fun UserProfileScreen(
    onNavigateToUserProfileScreen: () -> Unit,
    onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToAboutUsScreen: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    tokenPreferences: TokenPreferences,
    viewModel: UserProfileScreenViewModel = viewModel {
        UserProfileScreenViewModel(tokenPreferences)
    }
) {
    val state by viewModel.state.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
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
            if (state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.offset(y = (-50).dp),
                        color = Color.Green
                    )
                }
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Próximamente!",
                    modifier = Modifier.offset(x = (135).dp,y = (290).dp),
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
                    )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 90.dp),
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
                                .offset(x = 170.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.info_icon),
                            contentDescription = "info_icon",
                            modifier = Modifier
                                .size(30.dp)
                                .offset(x = 250.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = ripple(bounded = false, radius = 30.dp),
                                    onClick = { onNavigateToAboutUsScreen() }
                                )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.logout_button_icon),
                            contentDescription = "logout_button",
                            modifier = Modifier
                                .size(30.dp)
                                .offset(x = 270.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = ripple(bounded = false, radius = 30.dp),
                                    onClick = {
                                        tokenPreferences.clearToken()
                                        onNavigateToLoginScreen()
                                    }
                                )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.5f)
                            .padding(bottom = 15.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_image),
                            contentDescription = "user_image",
                            modifier = Modifier
                                .size(120.dp)
                        )
                        Text(
                            text = if (state.userName.isNotBlank()) state.userName else "Cargando...",
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
                        StatsBox("15", "Planes")
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
                            DataBox(modifier = Modifier.weight(0.5f), "Rol", "*****")
                            DataBox(modifier = Modifier.weight(0.5f), "Ciudad", "*****")
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(0.5f)
                        ) {
                            DataBox(modifier = Modifier.weight(0.5f), "Edad", "*****")
                            DataBox(
                                modifier = Modifier.weight(0.5f),
                                "Correo",
                                if (state.userEmail.isNotBlank()) {
                                    if (state.userEmail.length > 21) {
                                        "${state.userEmail.take(3)}...${state.userEmail.substringAfterLast("@", "")}"
                                    } else {
                                        state.userEmail
                                    }
                                } else "Cargando..."
                            )
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
                                .size(130.dp)
                                .padding(0.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.edit_button),
                                contentDescription = "active_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            }
        }
        BottomNavBar(
            modifier = Modifier
                .height(90.dp),
            onNavigateToHomeScreen,
            onNavigateToUserProfileScreen,
            onNavigateToCreatePlanScreen,
            onNavigateToProgressScreen
        )
    }
}