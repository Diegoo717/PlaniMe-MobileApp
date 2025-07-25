package com.example.planime_mobileapp.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun PlanCard(tittle: String, date: String, onClick: () -> Unit = {}){
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxHeight()
            .shadow(elevation = 5.dp, shape = RoundedCornerShape(22.dp))
            .clip(RoundedCornerShape(22.dp))
            .width(300.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .weight(0.7f)
                .fillMaxWidth()
                .background(brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFFF6B6B),
                        Color(0xFFFFD54F),
                    ),
                    startX = 0f,
                    endX = 800f
                ))
        ) {
            Image(
                painter = painterResource(id = R.drawable.planime_logo),
                contentDescription = "plan_backgorund",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp)

            )
        }
        Column(
            modifier = Modifier
                .weight(0.3f)
                .background(brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFA0D94A),
                        Color(0xFF4FC3F7),
                    ),
                    startY = 0f,
                    endY = 500f
                ))
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .height(80.dp)
                    .clip(RoundedCornerShape(22.dp)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Text(
                    text = tittle,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(5f, 5f),
                            blurRadius = 0f
                        )
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(2.dp)
                )
                Text(
                    text = date,
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(2f, 2f),
                            blurRadius = 0f
                        )
                    )
                )
            }
        }
    }
}