package com.example.planime_mobileapp.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.planime_mobileapp.components.BottomNavBar
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

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
            Column(
                modifier = Modifier
                    .weight(0.25f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                        .padding(top = 30.dp)
                        .weight(0.7f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.7f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Hola Luis, Bienvenido!",
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
                            )
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.3f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_image),
                            contentDescription = "user_image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .size(50.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.3f),
                    contentAlignment = Alignment.Center
                ) {
                    SearchBar(
                        query = query,
                        onQueryChange = { query = it },
                        onSearch = { active = false },
                        active = active,
                        onActiveChange = { active = it },
                        placeholder = { Text("Buscar...") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar"
                            )
                        },
                        trailingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Cerrar"
                                )
                            }
                        },
                        colors = SearchBarDefaults.colors(
                            containerColor = Color.Transparent,
                            dividerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .width(350.dp)
                            .height(50.dp)
                            .offset(y = (-40).dp)
                    ) {}
                    Box(
                        modifier = Modifier
                            .width(320.dp)
                            .height(2.dp)
                            .background(Color.Black)
                            .offset(y = (-0).dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(0.65f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp)
                        .padding(end = 20.dp)
                        .weight(0.1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tus Planes",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontFamily = fontFamilyGoogle,
                            textAlign = TextAlign.Center,
                            shadow = Shadow(
                                color = Color.White,
                                offset = Offset(3f, 3f),
                                blurRadius = 0f
                            )
                        )
                    )
                    Text(
                        text = "Ver todos",
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 20.sp,
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.15f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(130.dp)
                            .padding(0.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.active_button),
                            contentDescription = "active_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.expired_button),
                            contentDescription = "expired_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                    IconButton(
                        onClick = {},
                        modifier = Modifier.size(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.others_button),
                            contentDescription = "others_button",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .fillMaxSize()
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                        .padding(bottom = 80.dp)
                        .weight(0.75f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        modifier = Modifier
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
                                    text = "Muscletone",
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
                                    text = "13/06/2025",
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
            }
            BottomNavBar(modifier = Modifier
                .weight(0.1f)
            )
        }
    }

}