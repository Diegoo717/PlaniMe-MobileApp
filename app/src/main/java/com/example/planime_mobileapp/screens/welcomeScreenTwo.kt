package com.example.planime_mobileapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

@Composable
fun welcomeScreenTwo() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier .matchParentSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 55.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .weight(0.1f)
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
                    painter = painterResource(id = R.drawable.logo_pm),
                    contentDescription = "logo",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            Column (modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.fooddesign),
                    contentDescription = "path",
                    Modifier
                        .size(200.dp)
                )
                Text(text = "Tu alimentación puede ser inteligente, deliciosa y\ndiseñada solo para ti.",
                    fontSize = 35.sp,
                    fontFamily = fontFamilyGoogle,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth())
                Canvas(modifier = Modifier
                    .width(350.dp)
                ) {
                    drawLine(
                        color = Color.Gray,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = 5f
                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(end = 40.dp)
                .padding(bottom = 40.dp)
                .weight(0.2f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = "next",
                    Modifier
                        .size(90.dp)
                        .clickable {  }
                )
            }
        }
    }
}