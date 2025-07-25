@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.planime_mobileapp.ui.screens.dashboard.detailsplan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import coil.compose.AsyncImage
import coil.request.ImageRequest

private val MediumGreen = Color(0xFF2E4328)
private val LightGreen = Color(0xFFA1C398)
private val BorderGreen = Color(0xFF416039)

@Composable
fun DetailsPlanScreen(
    planId: Int,
    tokenPreferences: TokenPreferences,
    onBackClick: () -> Unit = {},
    onDownloadClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
    viewModel: DetailsPlanViewModel = viewModel {
        DetailsPlanViewModel(tokenPreferences, planId)
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Volver",
                                tint = Color.Black
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(state.plan?.imageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = "image_plan",
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.CenterStart,
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(),
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.Black.copy(alpha = 0.5f)
                                    ),
                                    startY = 0f,
                                    endY = Float.POSITIVE_INFINITY
                                )
                            )
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(16.dp)
                    ) {
                        Text(
                            text = state.formattedPlanName,
                            color = Color.White,
                            style = TextStyle(
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontFamilyGoogle,
                                textAlign = TextAlign.Center,
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(5f, 5f),
                                    blurRadius = 0f
                                )
                            )
                        )
                    }
                }

                Text(
                    text = "Creado el ${state.formattedCreatedAt} · Expira ${state.formattedExpiredAt}",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = fontFamilyGoogle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                Text(
                    text = "Detalles",
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamilyGoogle,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(3f, 3f),
                            blurRadius = 0f
                        )
                    ),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 16.dp)
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        DetailItem(
                            label = "Edad "+"\uD83D\uDCC6",
                            value = state.formattedAge,
                            labelFontSize = 20.sp,
                            valueFontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                        DetailItem(
                            label = "Genero "+"⚧\uFE0F",
                            value = state.formattedGender,
                            labelFontSize = 20.sp,
                            valueFontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        DetailItem(
                            label = "Peso "+"⚖\uFE0F",
                            value = state.formattedWeight,
                            labelFontSize = 20.sp,
                            valueFontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                        DetailItem(
                            label = "Altura "+"\uD83D\uDCCF",
                            value = state.formattedHeight,
                            labelFontSize = 20.sp,
                            valueFontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Row(modifier = Modifier.fillMaxWidth()) {
                        DetailItem(
                            label = "Nivel de actividad "+"\uD83C\uDFC3\uD83C\uDFFB\u200D➡\uFE0F",
                            value = state.formattedActivityLevel,
                            labelFontSize = 20.sp,
                            valueFontSize = 15.sp,
                            modifier = Modifier.weight(1f)
                        )
                        DetailItem(
                            label = "Objetivo físico "+"\uD83C\uDFF9",
                            value = state.formattedGoal,
                            labelFontSize = 20.sp,
                            valueFontSize = 16.sp,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.download_button),
                        contentDescription = "Descargar",
                        modifier = Modifier
                            .size(140.dp)
                            .clickable { onDownloadClick() },
                        contentScale = ContentScale.Fit
                    )

                    Image(
                        painter = painterResource(id = R.drawable.delete_button),
                        contentDescription = "Eliminar",
                        modifier = Modifier
                            .size(140.dp)
                            .clickable { onDeleteClick() },
                        contentScale = ContentScale.Fit
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun DetailItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    labelFontSize: androidx.compose.ui.unit.TextUnit = 16.sp,
    valueFontSize: androidx.compose.ui.unit.TextUnit = 18.sp
) {
    Column(
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Divider(
            color = BorderGreen,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            color = Color.Black,
            fontSize = labelFontSize,
            fontFamily = fontFamilyGoogle,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.White,
                    offset = Offset(2f, 2f),
                    blurRadius = 0f
                )
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = Color.Black,
            fontSize = valueFontSize,
            fontFamily = fontFamilyGoogle
        )
    }
}