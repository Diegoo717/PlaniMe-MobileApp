package com.example.planime_mobileapp.ui.screens.dashboard.createplanscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.res.painterResource
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import com.example.planime_mobileapp.ui.components.inputs.OwnDropdownCreatePlan
import com.example.planime_mobileapp.ui.components.inputs.OwnTextFieldCreatePlan
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Row
import com.example.planime_mobileapp.data.local.TokenPreferences
import kotlinx.coroutines.delay

@Composable
fun CreatePlanScreen(
    onNavigateToUserProfileScreen: () -> Unit,
    onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    tokenPreferences: TokenPreferences,
    viewModel: CreatePlanViewModel = viewModel(
        factory = CreatePlanViewModelFactory(tokenPreferences)
    )
) {
    val uiState by viewModel.uiState.collectAsState()
    val isLoading by viewModel.isLoading

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            delay(2000)
            onNavigateToHomeScreen()
        }
    }

    uiState.generalError?.let { error ->
        LaunchedEffect(error) {
            viewModel.clearGeneralError()
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
                        modifier = Modifier.offset(x = 140.dp)
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
                        .verticalScroll(rememberScrollState())
                ) {
                    OwnTextFieldCreatePlan(
                        tittle = "Edad",
                        modifier = Modifier.width(350.dp),
                        value = uiState.age,
                        onValueChange = viewModel::updateAge,
                        errorMessage = uiState.ageError
                    )

                    OwnTextFieldCreatePlan(
                        tittle = "Peso (kg)",
                        modifier = Modifier.width(350.dp),
                        value = uiState.weight,
                        onValueChange = viewModel::updateWeight,
                        errorMessage = uiState.weightError
                    )

                    OwnTextFieldCreatePlan(
                        tittle = "Altura (cm)",
                        modifier = Modifier.width(350.dp),
                        value = uiState.height,
                        onValueChange = viewModel::updateHeight,
                        errorMessage = uiState.heightError
                    )

                    OwnDropdownCreatePlan(
                        tittle = "Genero",
                        options = listOf("Masculino", "Femenino"),
                        modifier = Modifier.width(350.dp),
                        selectedOption = uiState.gender.ifEmpty { "Masculino" },
                        onSelectionChange = viewModel::updateGender,
                        errorMessage = uiState.genderError
                    )

                    OwnDropdownCreatePlan(
                        tittle = "Nivel de actividad física",
                        options = listOf(
                            "Sedentario",
                            "Ligero (1-2 días/semana)",
                            "Moderado (3-4 días/semana)",
                            "Activo (5-6 días/semana)"
                        ),
                        modifier = Modifier.width(350.dp),
                        selectedOption = uiState.activityLevel.ifEmpty { "Sedentario" },
                        onSelectionChange = viewModel::updateActivityLevel,
                        errorMessage = uiState.activityLevelError
                    )

                    OwnDropdownCreatePlan(
                        tittle = "Objetivo fisico",
                        options = listOf(
                            "Bajar de peso",
                            "Mantener un peso saludable",
                            "Aumentar masa muscular"
                        ),
                        modifier = Modifier.width(350.dp),
                        selectedOption = uiState.goal.ifEmpty { "Bajar de peso" },
                        onSelectionChange = viewModel::updateGoal,
                        errorMessage = uiState.goalError
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(160.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                                .align(Alignment.TopCenter)
                                .offset(y = (-40).dp)
                        ) {
                            if (isLoading) {
                                CircularProgressIndicator(
                                    color = Color(0xFFFF6B6B),
                                    modifier = Modifier
                                        .size(50.dp)
                                        .align(Alignment.Center)
                                )
                            }
                            else if (uiState.isSuccess) {
                                Text(
                                    text = uiState.successMessage ?: "¡Plan creado!",
                                    color = Color.White,
                                    fontSize = 26.sp,
                                    fontFamily = fontFamilyGoogle,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .padding(8.dp),
                                    style = TextStyle(
                                        shadow = Shadow(
                                            color = Color.Black,
                                            offset = Offset(2f, 2f),
                                            blurRadius = 5f
                                        )
                                    )
                                )
                            }
                            else {
                                Image(
                                    painter = painterResource(id = R.drawable.acept_button),
                                    contentDescription = "accept_button",
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .size(160.dp)
                                        .align(Alignment.Center)
                                        .clickable { viewModel.createPlan() }
                                )
                            }
                        }
                    }
                }
            }
        }

        BottomNavBar(
            modifier = Modifier.height(90.dp),
            onNavigateToHomeScreen,
            onNavigateToUserProfileScreen,
            onNavigateToCreatePlanScreen,
            onNavigateToProgressScreen
        )
    }
}