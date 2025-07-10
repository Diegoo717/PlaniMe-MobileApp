package com.example.planime_mobileapp.screens.user

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import com.example.planime_mobileapp.components.BottomNavBar
import com.example.planime_mobileapp.components.OwnDropdown
import com.example.planime_mobileapp.components.OwnTextField
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import com.example.planime_mobileapp.components.charts.WeightRecord
import com.example.planime_mobileapp.components.charts.WeightProgressChart
import com.example.planime_mobileapp.model.WeightOption

@Composable
fun ProgressScreen(){

    val weightRecords = listOf(
        WeightRecord("25/05/2025", 85f),
        WeightRecord("04/06/2025", 82f),
        WeightRecord("15/06/2025", 79f),
        WeightRecord("22/06/2025", 89f),
        WeightRecord("24/06/2025", 88f),
        WeightRecord("30/06/2025", 90f),
        WeightRecord("5/08/2025", 93f),
        WeightRecord("25/08/2025", 85f),
        WeightRecord("04/08/2025", 82f),
        WeightRecord("15/08/2025", 79f),
        WeightRecord("22/09/2025", 89f),
        WeightRecord("24/09/2025", 88f),
        WeightRecord("30/09/2025", 90f),
        WeightRecord("5/10/2025", 93f)
    )
    val goalWeight = 95f

    val weightOptions = WeightOption.generateWeightOptions()
    val weightTexts = remember { weightOptions.map { it.displayText } }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ultimate_background),
            contentDescription = "home_backgorund",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.1f)
                    .padding(top = 50.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_icon),
                    contentDescription = "arrow_icon",
                    modifier = Modifier
                        .size(30.dp)
                        .offset(x = 10.dp)
                )
                Text(
                    text = "Tu  Progreso",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(4f, 4f),
                            blurRadius = 0f
                        )
                    ),
                    modifier = Modifier
                        .offset(x = 110.dp)
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.45f)
                    .fillMaxWidth()
                    .padding(start = 10.dp)
            ){
                Text(
                    text = "Establece un objetivo",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(3f, 3f),
                            blurRadius = 0f
                        )
                    ),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                ){
                    OwnDropdown("Objetivo (kg)", weightTexts, modifier = Modifier.width(385.dp))
                }
                Text(
                    text = "Agrega un registro",
                    style = TextStyle(
                        fontSize = 30.sp,
                        fontFamily = fontFamilyGoogle,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(
                            color = Color.White,
                            offset = Offset(3f, 3f),
                            blurRadius = 0f
                        )
                    ),
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                )
                OwnTextField("Peso (kg)", modifier = Modifier.width(385.dp))
                OwnTextField("Fecha (dia/mes/año)", modifier = Modifier.width(385.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .width(390.dp)
                        .height(50.dp)
                ){
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .height(60.dp)
                            .width(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.acept_button),
                            contentDescription = "active_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(0.35f)
                    .fillMaxWidth()
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.1f)
                        .padding(start = 10.dp)
                ){
                    Text(
                        text = "Evolución de tú peso",
                        style = TextStyle(
                            fontSize = 32.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.9f)
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    WeightProgressChart(
                        records = weightRecords,
                        goalWeight = goalWeight,
                        modifier = Modifier
                    )
                }
            }
            BottomNavBar(
                modifier = Modifier
                    .weight(0.1f)
            )
        }
    }
}