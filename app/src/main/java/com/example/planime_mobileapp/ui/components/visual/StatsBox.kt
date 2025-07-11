package com.example.planime_mobileapp.ui.components.visual

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun StatsBox(value: String, tittle: String){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
            .border(
                width = 2.dp,
                color = Color(0xFFFF6B6B),
                shape = RoundedCornerShape(12.dp)
            )
    ) {
        Text(
            text = value,
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        )
        Text(text = tittle)
    }
}