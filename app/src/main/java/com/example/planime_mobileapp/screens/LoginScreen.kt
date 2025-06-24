package com.example.planime_mobileapp.screens

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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.planime_mobileapp.animations.buttons.animateButtonInteraction
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(onNavigateToRegisterScreen: () -> Unit) {

    var text by remember { mutableStateOf("") }
    var textTwo by remember { mutableStateOf("") }
    var isPressed by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

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
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                    value = text,
                    onValueChange = { newText -> text = newText },
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
                    value = textTwo,
                    onValueChange = { newText -> textTwo = newText },
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

            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.signin_button),
                    contentDescription = "signup_button",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.TopCenter)
                        .offset(x = 0.dp, y = -40.dp)
                )

                Text(
                    text = "o continuar con: ",
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
                        .offset(x = -85.dp, y = -60.dp)
                )
                Text(
                    text = "Registrate AQUI!",
                    color = Color.White,
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamilyGoogle,
                    textAlign = TextAlign.Center,
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
                                        onNavigateToRegisterScreen()
                                    }
                                }
                            )
                        }
                )
            }
        }
    }
}