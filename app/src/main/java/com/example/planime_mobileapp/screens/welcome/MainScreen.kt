package com.example.planime_mobileapp.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planime_mobileapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.input.pointer.pointerInput
import com.example.planime_mobileapp.animations.buttons.animateButtonInteraction
import com.example.planime_mobileapp.animations.screens.AnimatedScreen
import com.example.planime_mobileapp.animations.screens.ScreenTransitions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun MainScreen(onNavigateToLoginScreen: () -> Unit) {

    var isPressed by remember { mutableStateOf(false) }
    var isHovered by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mainscreen_background),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        AnimatedScreen(enter = ScreenTransitions.enterScreen, exit = ScreenTransitions.exitScreen) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 30.dp)
                    .padding(bottom = 80.dp),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "PlaniMe",
                        fontSize = 30.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(100.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.planime_logo),
                        contentDescription = "logo",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(70.dp)
                    )
                }
                Column(
                    modifier = Modifier
                        .height(500.dp)
                        .padding(bottom = 70.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ironbananan),
                        contentDescription = "ironbananan",
                        Modifier
                            .size(250.dp)
                    )
                    Text(
                        text = "Diseñamos tu dieta,\nconquistas tus metas!",
                        fontSize = 35.sp,
                        fontFamily = fontFamilyGoogle,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Text(
                    text = "Comenzar",
                    fontFamily = fontFamilyGoogle,
                    fontSize = 50.sp,
                    color = (Color.White),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
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