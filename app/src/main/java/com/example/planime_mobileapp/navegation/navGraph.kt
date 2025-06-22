package com.example.planime_mobileapp.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planime_mobileapp.screens.loadingScreen
import com.example.planime_mobileapp.screens.welcomeScreen
import com.example.planime_mobileapp.screens.welcomeScreenTwo
import com.example.planime_mobileapp.screens.welcomeScreenThree
import com.example.planime_mobileapp.screens.mainScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = routes.LOADINGSCREEN
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(routes.LOADINGSCREEN){
            loadingScreen(
                onNavigateToWelcomeScreen = {navController.navigate((routes.WELCOMESCREEN))}
            )
        }
        composable(routes.WELCOMESCREEN){
            welcomeScreen(
                onNavigateToWSTwo = {navController.navigate((routes.WELCOMESCREENTWO))}
            )
        }
        composable(routes.WELCOMESCREENTWO){
            welcomeScreenTwo(
                onNavigateToWSThree = {navController.navigate((routes.WELCOMESCREENTHREE))}
            )
        }
        composable(routes.WELCOMESCREENTHREE){
            welcomeScreenThree(
                onNavigateToMainScreen = {navController.navigate((routes.MAINSCREEN))}
            )
        }
        composable(routes.MAINSCREEN){
            mainScreen(
                onNavigateToLoginScreen = {}
            )
        }
    }
}