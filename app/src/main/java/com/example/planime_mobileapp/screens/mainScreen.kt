package com.example.planime_mobileapp.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.planime_mobileapp.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun mainScreen(){

    Box(
      modifier = Modifier
          .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier .matchParentSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 35.dp)
            .padding(bottom = 55.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = "PlaniMe",
                fontSize = 30.sp,
                fontFamily = fontFamilyGoogle,
                textAlign = TextAlign.Center,
                modifier = Modifier
                .fillMaxWidth()
            )
            Column (modifier = Modifier
                .height(500.dp)
                .padding(bottom = 70.dp)
                .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = R.drawable.ironbananan),
                    contentDescription = "ironbananan",
                    Modifier
                        .size(250.dp)
                )
                Text(text = "Diseñamos tu dieta, conquistas tus metas!",
                    fontSize = 30.sp,
                    fontFamily = fontFamilyGoogle,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                    .fillMaxWidth())
            }

            Button(onClick = {},
                modifier = Modifier
                    .border(
                    width = 2.dp,
                    color = Color(0xFF000000),
                    shape = RoundedCornerShape(30.dp)
                    )) {
                Text(text = "Comenzar",
                    fontFamily = fontFamilyGoogle,
                    fontSize = 30.sp,
                    )
            }
        }
    }
}