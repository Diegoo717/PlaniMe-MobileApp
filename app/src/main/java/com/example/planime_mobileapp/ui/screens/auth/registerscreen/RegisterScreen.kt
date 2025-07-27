package com.example.planime_mobileapp.ui.screens.auth.registerscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.animations.buttons.animateButtonInteraction
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    onNavigateToLoginScreen: () -> Unit,
    viewModel: RegisterScreenViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    var isPressed by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    var isRegisterPressed by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            delay(2000)
            onNavigateToLoginScreen()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "backgroundlogin",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        AnimatedScreen(
            enter = ScreenTransitions.enterScaleFromCenter,
            exit = ScreenTransitions.exitScaleToCenter
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.25f)
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.planime_logo),
                        contentDescription = "planime_logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.BottomCenter)
                    )
                    Text(
                        text = "PlaniMe",
                        fontSize = 35.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = 20.dp)
                            .align(Alignment.BottomCenter)
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.55f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Registra tu cuenta",
                        style = TextStyle(
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            shadow = Shadow(
                                color = Color.White,
                                offset = Offset(4f, 4f),
                                blurRadius = 0f
                            )
                        ),
                        modifier = Modifier.fillMaxWidth()
                    )
                    TextField(
                        value = uiState.firstName,
                        onValueChange = viewModel::updateFirstName,
                        label = {
                            Text(
                                "Nombre/s",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        placeholder = {
                            Text(
                                "Escribe aquí",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 30.dp)
                            .drawWithContent {
                                drawContent()
                                drawIntoCanvas { canvas ->
                                    val paint = Paint().apply {
                                        color = Color.Black.copy(alpha = 0.2f)
                                        this.asFrameworkPaint().apply {
                                            isAntiAlias = true
                                            maskFilter = android.graphics.BlurMaskFilter(8f, android.graphics.BlurMaskFilter.Blur.NORMAL)
                                        }
                                    }

                                    val shadowHeight = 4.dp.toPx()
                                    val cornerRadius = 12.dp.toPx()
                                    val shadowWidthReduction = 7.dp.toPx()

                                    canvas.drawRoundRect(
                                        left = shadowWidthReduction,
                                        top = size.height - shadowHeight,
                                        right = size.width - shadowWidthReduction,
                                        bottom = size.height,
                                        radiusX = cornerRadius,
                                        radiusY = cornerRadius,
                                        paint = paint
                                    )
                                }
                            },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFEFF299),
                            focusedContainerColor = Color(0xFFEFF299),
                            focusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    TextField(
                        value = uiState.lastName,
                        onValueChange = viewModel::updateLastName,
                        label = {
                            Text(
                                "Apellidos",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        placeholder = {
                            Text(
                                "Escribe aquí",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 20.dp)
                            .drawWithContent {
                                drawContent()
                                drawIntoCanvas { canvas ->
                                    val paint = Paint().apply {
                                        color = Color.Black.copy(alpha = 0.2f)
                                        this.asFrameworkPaint().apply {
                                            isAntiAlias = true
                                            maskFilter = android.graphics.BlurMaskFilter(8f, android.graphics.BlurMaskFilter.Blur.NORMAL)
                                        }
                                    }

                                    val shadowHeight = 4.dp.toPx()
                                    val cornerRadius = 12.dp.toPx()
                                    val shadowWidthReduction = 7.dp.toPx()

                                    canvas.drawRoundRect(
                                        left = shadowWidthReduction,
                                        top = size.height - shadowHeight,
                                        right = size.width - shadowWidthReduction,
                                        bottom = size.height,
                                        radiusX = cornerRadius,
                                        radiusY = cornerRadius,
                                        paint = paint
                                    )
                                }
                            },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFEFF299),
                            focusedContainerColor = Color(0xFFEFF299),
                            focusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    TextField(
                        value = uiState.email,
                        onValueChange = viewModel::updateEmail,
                        label = {
                            Text(
                                "Correo electrónico",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        placeholder = {
                            Text(
                                "ejemplo@correo.com",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 20.dp)
                            .drawWithContent {
                                drawContent()
                                drawIntoCanvas { canvas ->
                                    val paint = Paint().apply {
                                        color = Color.Black.copy(alpha = 0.2f)
                                        this.asFrameworkPaint().apply {
                                            isAntiAlias = true
                                            maskFilter = android.graphics.BlurMaskFilter(8f, android.graphics.BlurMaskFilter.Blur.NORMAL)
                                        }
                                    }

                                    val shadowHeight = 4.dp.toPx()
                                    val cornerRadius = 12.dp.toPx()
                                    val shadowWidthReduction = 7.dp.toPx()

                                    canvas.drawRoundRect(
                                        left = shadowWidthReduction,
                                        top = size.height - shadowHeight,
                                        right = size.width - shadowWidthReduction,
                                        bottom = size.height,
                                        radiusX = cornerRadius,
                                        radiusY = cornerRadius,
                                        paint = paint
                                    )
                                }
                            },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFEFF299),
                            focusedContainerColor = Color(0xFFEFF299),
                            focusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    TextField(
                        value = uiState.password,
                        onValueChange = viewModel::updatePassword,
                        label = {
                            Text(
                                "Contraseña",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        placeholder = {
                            Text(
                                "Mínimo 8 caracteres",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 20.dp)
                            .drawWithContent {
                                drawContent()
                                drawIntoCanvas { canvas ->
                                    val paint = Paint().apply {
                                        color = Color.Black.copy(alpha = 0.2f)
                                        this.asFrameworkPaint().apply {
                                            isAntiAlias = true
                                            maskFilter = android.graphics.BlurMaskFilter(8f, android.graphics.BlurMaskFilter.Blur.NORMAL)
                                        }
                                    }

                                    val shadowHeight = 4.dp.toPx()
                                    val cornerRadius = 12.dp.toPx()
                                    val shadowWidthReduction = 7.dp.toPx()

                                    canvas.drawRoundRect(
                                        left = shadowWidthReduction,
                                        top = size.height - shadowHeight,
                                        right = size.width - shadowWidthReduction,
                                        bottom = size.height,
                                        radiusX = cornerRadius,
                                        radiusY = cornerRadius,
                                        paint = paint
                                    )
                                }
                            },
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFEFF299),
                            focusedContainerColor = Color(0xFFEFF299),
                            focusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                    uiState.errorMessage?.let { errorMessage ->
                        Text(
                            text = errorMessage,
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontFamily = fontFamilyGoogle,
                            modifier = Modifier.padding(top = 20.dp, bottom = 0.dp)
                        )
                    }
                    uiState.successMessage?.let { successMessage ->
                        Text(
                            text = successMessage,
                            color = Color.White,
                            fontSize = 20.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .padding(top = 10.dp),
                            style = TextStyle(
                                shadow = Shadow(
                                    color = Color.Black,
                                    offset = Offset(2f, 2f),
                                    blurRadius = 5f
                                )
                            )
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .offset(y = (-50).dp)
                    ) {
                        if (uiState.isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .size(50.dp)
                                    .offset(y = 40.dp)
                                    .align(Alignment.Center),
                                color = Color(0xFF4CAF50)
                            )
                        } else {
                            Image(
                                painter = painterResource(id = R.drawable.signup_button),
                                contentDescription = "signup_button",
                                contentScale = ContentScale.Fit,
                                modifier = Modifier
                                    .size(130.dp)
                                    .animateButtonInteraction(isRegisterPressed, false)
                                    .clickable(
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() },
                                        onClick = {}
                                    )
                                    .pointerInput(Unit) {
                                        detectTapGestures(
                                            onPress = { isRegisterPressed = true },
                                            onTap = {
                                                scope.launch {
                                                    delay(100)
                                                    isRegisterPressed = false
                                                    viewModel.register()
                                                }
                                            }
                                        )
                                    }
                            )
                        }
                    }

                    Text(
                        text = "¿Ya tienes cuenta?",
                        fontSize = 23.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(x = -100.dp, y = -60.dp)
                    )

                    Text(
                        text = "Inicia sesión AQUI!",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            shadow = Shadow(
                                color = Color.Black,
                                offset = Offset(2f, 2f),
                                blurRadius = 5f
                            )
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(x = 85.dp, y = -60.dp)
                            .animateButtonInteraction(isPressed, isHovered)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = {}
                            )
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = { isPressed = true },
                                    onTap = {
                                        scope.launch {
                                            delay(100)
                                            isPressed = false
                                            onNavigateToLoginScreen()
                                        }
                                    }
                                )
                            }
                    )
                }
            }
        }
    }
}