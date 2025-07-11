package com.example.planime_mobileapp.ui.components.visual

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun DataBox(modifier: Modifier, tittle: String, value: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxHeight()
    ){
        Text(
            text = tittle,
            style = TextStyle(
                fontSize = 26.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = value,
            color = Color.Gray,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
            )
        )
    }
}