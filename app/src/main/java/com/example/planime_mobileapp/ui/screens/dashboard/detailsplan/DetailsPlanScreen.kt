@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.planime_mobileapp.ui.screens.dashboard.detailsplan

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
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
import com.example.planime_mobileapp.ui.components.visual.DetailItem

@Composable
fun DetailsPlanScreen(
    planId: Int,
    tokenPreferences: TokenPreferences,
    onBackClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {},
) {
    val context = LocalContext.current
    var isImageExpanded by remember { mutableStateOf(false) }

    val viewModel: DetailsPlanViewModel = viewModel(
        factory = DetailsPlanViewModelFactory(
            tokenPreferences = tokenPreferences,
            planId = planId,
            context = context
        )
    )

    val state by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
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
                    modifier = Modifier.fillMaxSize()
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
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null
                            ) { isImageExpanded = true }
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
                        IconButton(
                            onClick = { viewModel.onDownloadClick() },
                            modifier = Modifier.size(140.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.download_button),
                                contentDescription = "download_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                        IconButton(
                            onClick = { viewModel.onDeleteClick() },
                            modifier = Modifier.size(140.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.delete_button),
                                contentDescription = "delete_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
        AnimatedVisibility(
            visible = isImageExpanded,
            enter = fadeIn(animationSpec = tween(300)),
            exit = fadeOut(animationSpec = tween(300)),
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.9f))
                    .clickable { isImageExpanded = false },
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(state.plan?.imageUrl)
                        .build(),
                    contentDescription = "Imagen expandida",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.9f)
                        .padding(16.dp)
                )
            }
        }
    }
}


