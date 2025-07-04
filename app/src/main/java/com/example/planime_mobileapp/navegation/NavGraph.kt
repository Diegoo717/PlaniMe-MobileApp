package com.example.planime_mobileapp.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planime_mobileapp.screens.welcome.LoadingScreen
import com.example.planime_mobileapp.screens.auth.LoginScreen
import com.example.planime_mobileapp.screens.welcome.WelcomeScreen
import com.example.planime_mobileapp.screens.welcome.WelcomeScreenTwo
import com.example.planime_mobileapp.screens.welcome.WelcomeScreenThree
import com.example.planime_mobileapp.screens.welcome.MainScreen
import com.example.planime_mobileapp.screens.auth.RegisterScreen

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
            LoadingScreen(
                onNavigateToWelcomeScreen = {navController.navigate((routes.WELCOMESCREEN))}
            )
        }
        composable(routes.WELCOMESCREEN){
            WelcomeScreen(
                onNavigateToWSTwo = {navController.navigate((routes.WELCOMESCREENTWO))}
            )
        }
        composable(routes.WELCOMESCREENTWO){
            WelcomeScreenTwo(
                onNavigateToWSThree = {navController.navigate((routes.WELCOMESCREENTHREE))}
            )
        }
        composable(routes.WELCOMESCREENTHREE){
            WelcomeScreenThree(
                onNavigateToMainScreen = {navController.navigate((routes.MAINSCREEN))}
            )
        }
        composable(routes.MAINSCREEN){
            MainScreen(
                onNavigateToLoginScreen = {navController.navigate((routes.LOGINSCREEN))}
            )
        }
        composable(routes.REGISTERSCREEN){
            RegisterScreen(
                onNavigateToLoginScreen = {navController.navigate((routes.LOGINSCREEN))}
            )
        }
        composable(routes.LOGINSCREEN){
            LoginScreen(
                onNavigateToRegisterScreen = {navController.navigate((routes.REGISTERSCREEN))}
            )
        }
    }
}