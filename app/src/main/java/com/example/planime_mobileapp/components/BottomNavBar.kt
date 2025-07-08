package com.example.planime_mobileapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planime_mobileapp.R
import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.material3.ripple

@Composable
fun BottomNavBar(modifier: Modifier = Modifier){
    Column(modifier = modifier
        .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFF6B6B),
                        Color(0xFFFF8E8E)
                    ),
                    startY = 0f,
                    endY = Float.POSITIVE_INFINITY
                ))
                .fillMaxHeight()
                .drawBehind {
                    drawRect(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.1f),
                                Color.Transparent
                            ),
                            startY = 0f,
                            endY = 30f
                        ),
                        size = Size(size.width, 15.dp.toPx())
                    )
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false, radius = 30.dp),
                        onClick = {}
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.home_icon),
                    contentDescription = "home_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(28.dp)
                )
                Text(text = "Inicio",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false, radius = 30.dp),
                        onClick = {}
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = "add_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(28.dp)
                )
                Text(text = "Crear Plan",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false, radius = 30.dp),
                        onClick = {}
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.goals_icon),
                    contentDescription = "goals_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(28.dp)
                )
                Text(text = "Progeso",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                    )
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = false, radius = 30.dp),
                        onClick = {}
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = "user_icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(28.dp)
                )
                Text(text = "Perfil",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }
    }
}