package com.example.planime_mobileapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun loadingScreen(){

    var isJumping by remember { mutableStateOf(false) }

    val offsetY by animateDpAsState(
        targetValue = if (isJumping) (-35).dp else 0.dp,
        animationSpec = spring(
            dampingRatio = 0.45f,
            stiffness = 90f
        )
    )
    LaunchedEffect(Unit) {
        delay(1000)
        isJumping = true
        delay(300)
        isJumping = false
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.main_background),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier .matchParentSize()
        )
        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "PlaniMe",
                fontSize = 40.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(130.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.logo_pm),
                contentDescription = "logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(80.dp)
                    .offset(y = offsetY)
            )
        }
    }
}
