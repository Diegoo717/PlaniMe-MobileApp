package com.example.planime_mobileapp.ui.screens.dashboard.progressscreen

import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import com.example.planime_mobileapp.ui.components.inputs.OwnDropdownProgress
import com.example.planime_mobileapp.ui.components.inputs.OwnTextField
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import com.example.planime_mobileapp.ui.components.charts.WeightRecord
import com.example.planime_mobileapp.ui.components.charts.WeightProgressChart
import com.example.planime_mobileapp.domain.model.user.progress.WeightOption
import com.example.planime_mobileapp.presentation.viewmodel.ProgressScreenViewModel
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import androidx.compose.ui.platform.LocalFocusManager
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ProgressScreen(
    onNavigateToUserProfileScreen: () -> Unit,
    onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    tokenPreferences: TokenPreferences,
    viewModel: ProgressScreenViewModel = viewModel(
        factory = ProgressViewModelFactory(tokenPreferences)
    )
) {
    val uiState by viewModel.uiState.collectAsState()

    val weightOptions = remember { WeightOption.generateWeightOptions() }
    val focusManager = LocalFocusManager.current
    var weightText by remember { mutableStateOf("") }
    var dateText by remember { mutableStateOf("") }

    val weightTexts = remember(weightOptions) {
        weightOptions.map { it.displayText }
    }

    LaunchedEffect(Unit) {
        viewModel.loadAllWeightRecords()
    }

    val weightRecords = remember(uiState.weightRecordsList) {
        uiState.weightRecordsList.map { record ->
            val formattedDate = try {
                val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).apply {
                    isLenient = false
                }
                val outputFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val date = inputFormat.parse(record.date)
                outputFormat.format(date ?: Date())
            } catch (e: Exception) {
                record.date
            }
            WeightRecord(date = formattedDate, weight = record.weight.toFloat())
        }.sortedBy {
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(it.date) ?: Date()
        }
    }

    val goalWeight = uiState.selectedWeightOption?.value?.toFloat() ?: 95f

    LaunchedEffect(uiState.successRecordMessage) {
        if (uiState.successRecordMessage != null) {
            weightText = ""
            dateText = ""
            focusManager.clearFocus()
            delay(3000)
            viewModel.clearSuccesMessage()
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
                        text = "Tu Progreso",
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
                        modifier = Modifier.offset(x = 135.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .weight(0.45f)
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Establece un objetivo",
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                shadow = Shadow(
                                    color = Color.White,
                                    offset = Offset(3f, 3f),
                                    blurRadius = 0f
                                )
                            ),
                            modifier = Modifier.padding(bottom = 10.dp)
                        )

                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(20.dp)
                                    .padding(end = 10.dp),
                                strokeWidth = 2.dp,
                                color = Color.Green
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                    ) {
                        OwnDropdownProgress(
                            tittle = "Objetivo (kg)",
                            options = weightTexts,
                            selectedIndex = weightOptions.indexOfFirst {
                                it.value == uiState.selectedWeightOption?.value
                            }.takeIf { it != -1 },
                            onSelectionChanged = { selectedIndex ->
                                val selectedOption = weightOptions[selectedIndex]
                                viewModel.onWeightOptionSelected(selectedOption)
                            },
                            modifier = Modifier.width(385.dp)
                        )
                    }

                    Text(
                        text = "Agrega un registro",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            shadow = Shadow(
                                color = Color.White,
                                offset = Offset(3f, 3f),
                                blurRadius = 0f
                            )
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )

                    Column {
                        OwnTextField(
                            title = "Peso (kg)",
                            value = weightText,
                            onValueChange = {
                                weightText = it
                                if (uiState.weightError != null) {
                                    viewModel.clearWeightError()
                                }
                            },
                            modifier = Modifier.width(385.dp)
                        )

                        uiState.weightError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 16.sp,
                                fontFamily = fontFamilyGoogle,
                                modifier = Modifier.padding(start = 16.dp, bottom = 20.dp)
                            )
                        }
                    }

                    Column {
                        OwnTextField(
                            title = "Fecha (dia/mes/año)",
                            value = dateText,
                            onValueChange = {
                                dateText = it
                                if (uiState.dateError != null) {
                                    viewModel.clearDateError()
                                }
                            },
                            modifier = Modifier.width(385.dp)
                        )

                        uiState.dateError?.let { error ->
                            Text(
                                text = error,
                                color = Color.Red,
                                fontSize = 16.sp,
                                fontFamily = fontFamilyGoogle,
                                modifier = Modifier.padding(start = 16.dp)
                            )
                        }
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .width(390.dp)
                            .height(50.dp)
                    ) {
                        uiState.successRecordMessage?.let { message ->
                            Text(
                                text = message,
                                color = Color.White,
                                fontSize = 18.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
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
                        IconButton(
                            onClick = {
                                viewModel.setWeightRecord(weightText, dateText)
                            },
                            modifier = Modifier
                                .height(60.dp)
                                .width(100.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.acept_button),
                                contentDescription = "accept_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .fillMaxSize()
                            )
                        }
                    }
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .weight(0.35f)
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.1f)
                            .padding(start = 10.dp)
                    ) {
                        Text(
                            text = "Evolución de tu peso",
                            style = TextStyle(
                                fontSize = 32.sp,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.9f)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.CenterVertically),
                                color = Color.Green
                            )
                        } else if (uiState.errorMessage != null) {
                            Text(
                                text = uiState.errorMessage!!,
                                color = Color.Red,
                                fontSize = 16.sp,
                                fontFamily = fontFamilyGoogle,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        } else if (weightRecords.isEmpty()) {
                            Text(
                                text = "No hay registros de peso",
                                fontSize = 16.sp,
                                fontFamily = fontFamilyGoogle,
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        } else {
                            WeightProgressChart(
                                records = weightRecords,
                                goalWeight = goalWeight,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
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