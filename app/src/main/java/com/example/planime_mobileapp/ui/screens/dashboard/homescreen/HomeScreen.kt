package com.example.planime_mobileapp.ui.screens.dashboard.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.R
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.planime_mobileapp.ui.components.navigation.BottomNavBar
import com.example.planime_mobileapp.ui.components.cards.PlanCard
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToUserProfileScreen: () -> Unit, onNavigateToCreatePlanScreen: () -> Unit,
    onNavigateToProgressScreen: () -> Unit, onNavigateToHomeScreen: () -> Unit
) {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    var PlansList = 3
    var PlanTittle = "Muscletone"
    var PlanDate = "13/16/2025"

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
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                        .padding(bottom = 80.dp)
                        .weight(0.75f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    contentPadding = PaddingValues(start = 50.dp, end = 50.dp),
                ) {
                    items(PlansList) { index ->
                        PlanCard(PlanTittle, PlanDate)
                    }
                }
            }
            BottomNavBar(
                modifier = Modifier
                    .weight(0.1f),
                onNavigateToHomeScreen,
                onNavigateToUserProfileScreen,
                onNavigateToCreatePlanScreen,
                onNavigateToProgressScreen
            )
        }
    }

}