package com.example.planime_mobileapp.ui.screens.auth.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.animations.buttons.animateButtonInteraction
import com.example.planime_mobileapp.ui.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.ui.animations.screens.ScreenTransitions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onNavigateToRegisterScreen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    tokenPreferences: TokenPreferences,
    viewModel: LoginScreenViewModel = viewModel(
        factory = LoginViewModelFactory(tokenPreferences)
    )
) {

    val uiState by viewModel.uiState.collectAsState()

    var text by remember { mutableStateOf("") }
    var textTwo by remember { mutableStateOf("") }
    var isPressed by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    var isPressedTwo by remember { mutableStateOf(false) }
    var isHoveredTwo by remember { mutableStateOf(false) }
    var isPressedSignIn by remember { mutableStateOf(false) }
    var isHoveredSignIn by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(uiState.isSuccess) {
        if (uiState.isSuccess) {
            delay(2000)
            onNavigateToHomeScreen()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "backgroundlogin",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        AnimatedScreen(enter = ScreenTransitions.enterScaleFromCenter, exit = ScreenTransitions.exitScaleToCenter) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Box(
                    modifier = Modifier
                        .weight(0.35f)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.planime_logo),
                        contentDescription = "planime_logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(280.dp)
                            .align(Alignment.BottomCenter)
                    )
                    Text(
                        text = "PlaniMe",
                        fontSize = 40.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(y = (0).dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(0.35f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Ingresa a tu cuenta",
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                    TextField(
                        value = uiState.email,
                        onValueChange = viewModel::updateEmail,
                        label = {
                            Text(
                                "Correo electronico",
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
                            .padding(top = 40.dp),
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
                                "Escribe aquí",
                                style = TextStyle(fontFamily = fontFamilyGoogle),
                                fontSize = 20.sp
                            )
                        },
                        modifier = Modifier
                            .width(300.dp)
                            .padding(top = 30.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = Color(0xFFEFF299),
                            focusedContainerColor = Color(0xFFEFF299),
                            focusedLabelColor = Color.Black,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                        )
                    )
                }

                uiState.errorMessage?.let { errorMessage ->
                    Text(
                        text = errorMessage,
                        color = Color.Red,
                        fontSize = 20.sp,
                        fontFamily = fontFamilyGoogle,
                        modifier = Modifier.padding(top = 0.dp, bottom = 30.dp)
                    )
                }
                uiState.successMessage?.let { successMessage ->
                    Text(
                        text = successMessage,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = fontFamilyGoogle,
                        modifier = Modifier.padding(top = 0.dp, bottom = 30.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .fillMaxWidth()
                ) {
                    if (uiState.isLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .offset(y= -100.dp)
                                .size(50.dp)
                                .align(Alignment.Center),
                            color = Color(0xFF4CAF50)
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.signin_button),
                            contentDescription = "signup_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(130.dp)
                                .align(Alignment.TopCenter)
                                .offset(x = 0.dp, y = -40.dp)
                                .animateButtonInteraction(isPressedSignIn, isHoveredSignIn)
                                .clickable(
                                    indication = null,
                                    interactionSource = remember { MutableInteractionSource() },
                                    onClick = {}
                                )
                                .pointerInput(Unit) {
                                    detectTapGestures(
                                        onPress = { isPressedSignIn = true },
                                        onTap = {
                                            scope.launch {
                                                delay(100)
                                                isPressedSignIn = false
                                                viewModel.signin()
                                            }
                                        }
                                    )
                                }
                        )
                    }
                    Text(
                        text = "o si prefieres: ",
                        fontSize = 20.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .offset(x = 0.dp, y = -50.dp)
                    )

                    Image(
                        painter = painterResource(id = R.drawable.android_light_rd_si),
                        contentDescription = "signup_button",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(150.dp)
                            .align(Alignment.TopCenter)
                            .offset(x = 0.dp, y = 50.dp)
                    )
                    Text(
                        text = "¿No tienes cuenta?",
                        fontSize = 23.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(x = -85.dp, y = -70.dp)
                    )
                    Text(
                        text = "Registrate AQUI!",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(x = 85.dp, y = -70.dp)
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
                                            onNavigateToRegisterScreen()
                                        }
                                    }
                                )
                            }
                    )
                    Text(
                            text = "¿Haz olvidado tu contraseña?",
                    fontSize = 23.sp,
                    fontFamily = fontFamilyGoogle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .offset(x = -65.dp, y = -30.dp)
                    )
                    Text(
                        text = "HAZ AQUI!",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(x = 125.dp, y = -30.dp)
                            .animateButtonInteraction(isPressedTwo, isHoveredTwo)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() },
                                onClick = {}
                            )
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onPress = { isPressedTwo = true },
                                    onTap = {
                                        scope.launch {
                                            delay(100)
                                            isPressedTwo = false
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
