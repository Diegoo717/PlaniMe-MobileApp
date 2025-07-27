package com.example.planime_mobileapp.ui.screens.dashboard.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import com.example.planime_mobileapp.ui.components.cards.PlanCard
import com.example.planime_mobileapp.ui.components.inputs.StaticSearchBar
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun HomeScreen(
    onNavigateToUserProfileScreen: () -> Unit,
    onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToPlanDetails: (Int) -> Unit,
    tokenPreferences: TokenPreferences,
    viewModel: HomeViewModel = viewModel { HomeViewModel(tokenPreferences) }
) {
    val state by viewModel.state.collectAsState()
    var query by remember { mutableStateOf("") }

    val filteredPlans = remember(query, state.plansList) {
        if (query.isEmpty()) {
            state.plansList
        } else {
            state.plansList.filter { plan ->
                plan.name.contains(query, ignoreCase = true) ||
                        plan.date.contains(query, ignoreCase = true)
            }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.ultimate_background),
            contentDescription = "home_background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        AnimatedScreen(
            enter = ScreenTransitions.enterFromTop,
            exit = ScreenTransitions.exitToBottom
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 90.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .weight(0.25f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 30.dp)
                            .weight(0.7f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.7f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Hola ${state.userName}, Bienvenido!",
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
                                )
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.3f),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.user_image),
                                contentDescription = "user_image",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.size(50.dp)
                            )
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.3f),
                        contentAlignment = Alignment.Center
                    ) {
                        StaticSearchBar(
                            query = query,
                            onQueryChange = { query = it },
                            placeholder = "Buscar...",
                            modifier = Modifier
                                .width(350.dp)
                                .height(50.dp)
                                .offset(y = (-20).dp)
                        )

                        Box(
                            modifier = Modifier
                                .width(320.dp)
                                .height(2.dp)
                                .background(Color.Black)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .weight(0.65f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .weight(0.1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Tus Planes",
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
                            text = "Ver todos",
                            style = TextStyle(
                                color = Color.Gray,
                                fontSize = 20.sp,
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
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.15f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(130.dp)
                                .padding(0.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.active_button),
                                contentDescription = "active_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.expired_button),
                                contentDescription = "expired_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        IconButton(
                            onClick = {},
                            modifier = Modifier.size(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.others_button),
                                contentDescription = "others_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.75f)
                    ) {
                        if (state.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .offset(y = -100.dp)
                                    .size(100.dp)
                                    .align(Alignment.Center),
                                color = Color(0xFF4CAF50)
                            )
                        } else if(state.totalPlans == 0){
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "No hay planes disponibles...",
                                    style = TextStyle(
                                        fontSize = 28.sp,
                                        fontFamily = fontFamilyGoogle,
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    text = "Crea uno ahora mismo ;)",
                                    style = TextStyle(
                                        fontSize = 22.sp,
                                        fontFamily = fontFamilyGoogle,
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.DarkGray
                                    )
                                )
                            }
                        }else{
                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 50.dp, bottom = 80.dp)
                                    .fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(24.dp),
                                contentPadding = PaddingValues(horizontal = 50.dp),
                            ) {
                                items(filteredPlans.size) { index ->
                                    val planItem = filteredPlans[index]
                                    PlanCard(
                                        planItem.name,
                                        planItem.date,
                                        onClick = { onNavigateToPlanDetails(planItem.id) }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        BottomNavBar(
            modifier = Modifier.height(90.dp),
            onNavigateToHomeScreen = onNavigateToHomeScreen,
            onNavigateToUserProfileScreen = onNavigateToUserProfileScreen,
            onNavigateToCreatePlanScreen = onNavigateToCreatePlanScreen,
            onNavigateToProgressScreen = onNavigateToProgressScreen
        )
    }
}

