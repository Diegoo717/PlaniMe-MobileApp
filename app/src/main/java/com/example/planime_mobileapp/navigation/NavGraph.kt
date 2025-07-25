package com.example.planime_mobileapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.planime_mobileapp.data.local.AppPreferences
import com.example.planime_mobileapp.data.local.TokenPreferences
import com.example.planime_mobileapp.ui.screens.welcome.loadingscreen.LoadingScreen
import com.example.planime_mobileapp.ui.screens.auth.loginscreen.LoginScreen
import com.example.planime_mobileapp.ui.screens.welcome.welcomescreen.WelcomeScreen
import com.example.planime_mobileapp.ui.screens.welcome.welcomescreentwo.WelcomeScreenTwo
import com.example.planime_mobileapp.ui.screens.welcome.welcomescreenthree.WelcomeScreenThree
import com.example.planime_mobileapp.ui.screens.welcome.mainscreen.MainScreen
import com.example.planime_mobileapp.ui.screens.auth.registerscreen.RegisterScreen
import com.example.planime_mobileapp.ui.screens.dashboard.aboutusscreen.AboutUsScreen
import com.example.planime_mobileapp.ui.screens.dashboard.createplanscreen.CreatePlanScreen
import com.example.planime_mobileapp.ui.screens.dashboard.detailsplan.DetailsPlanScreen
import com.example.planime_mobileapp.ui.screens.dashboard.homescreen.HomeScreen
import com.example.planime_mobileapp.ui.screens.dashboard.progressscreen.ProgressScreen
import com.example.planime_mobileapp.ui.screens.dashboard.userprofile.UserProfileScreen
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
    appPreferences: AppPreferences,
    tokenPreferences: TokenPreferences
) {

    NavHost(
        navController = navController,
        startDestination = routes.LOADINGSCREEN
    ){
        composable(routes.LOADINGSCREEN){
            val destination = if(appPreferences.isOnboardingCompleted()){
                if(tokenPreferences.hasToken()){
                    routes.HOMESCREEN
                }else{
                    routes.LOGINSCREEN
                }
            }else{
                routes.WELCOMESCREEN
            }
            LoadingScreen(
                onNavigateToWelcomeScreen = {navController.navigate((destination))}
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
                onNavigateToLoginScreen = {navController.navigate((routes.LOGINSCREEN))},
                appPreferences = appPreferences
            )
        }
        composable(routes.REGISTERSCREEN){
            RegisterScreen(
                onNavigateToLoginScreen = {navController.navigate((routes.LOGINSCREEN))}
            )
        }
        composable(routes.LOGINSCREEN){
            LoginScreen(
                onNavigateToRegisterScreen = {navController.navigate((routes.REGISTERSCREEN))},
                onNavigateToHomeScreen = {navController.navigate((routes.HOMESCREEN))},
                tokenPreferences = tokenPreferences
            )
        }
        composable(routes.HOMESCREEN){
            HomeScreen(
                onNavigateToUserProfileScreen = {navController.navigate((routes.USERPROFILESCREEN))},
                onNavigateToCreatePlanScreen = {navController.navigate((routes.CREATEPLANSCREEN))},
                onNavigateToProgressScreen = {navController.navigate((routes.PROGRESSSCREEN))},
                onNavigateToHomeScreen = {navController.navigate((routes.HOMESCREEN))},
                onNavigateToPlanDetails = { planId ->
                    navController.navigate("details_plan_screen/$planId")
                },
                tokenPreferences = tokenPreferences
            )
        }
        composable(
            route = routes.DETAILSPLANSCREEN,
            arguments = listOf(navArgument("planId") { type = NavType.IntType })
        ) { backStackEntry ->
            val planId = backStackEntry.arguments?.getInt("planId") ?: 0
            DetailsPlanScreen(
                planId = planId,
                onBackClick = { navController.navigateUp() },
                tokenPreferences = tokenPreferences
            )
        }
        composable(routes.USERPROFILESCREEN){
            UserProfileScreen(
                onNavigateToUserProfileScreen = {navController.navigate((routes.USERPROFILESCREEN))},
                onNavigateToCreatePlanScreen = {navController.navigate((routes.CREATEPLANSCREEN))},
                onNavigateToProgressScreen = {navController.navigate((routes.PROGRESSSCREEN))},
                onNavigateToHomeScreen = {navController.navigate((routes.HOMESCREEN))},
                onNavigateToAboutUsScreen = {navController.navigate((routes.ABOUTUSSCREEN))},
                onNavigateToLoginScreen = {navController.navigate((routes.LOGINSCREEN))},
                tokenPreferences = tokenPreferences
            )
        }
        composable(routes.CREATEPLANSCREEN){
            CreatePlanScreen(
                onNavigateToUserProfileScreen = {navController.navigate((routes.USERPROFILESCREEN))},
                onNavigateToCreatePlanScreen = {navController.navigate((routes.CREATEPLANSCREEN))},
                onNavigateToProgressScreen = {navController.navigate((routes.PROGRESSSCREEN))},
                onNavigateToHomeScreen = {navController.navigate((routes.HOMESCREEN))},
                tokenPreferences = tokenPreferences
            )
        }
        composable(routes.PROGRESSSCREEN){
            ProgressScreen(
                onNavigateToUserProfileScreen = {navController.navigate((routes.USERPROFILESCREEN))},
                onNavigateToCreatePlanScreen = {navController.navigate((routes.CREATEPLANSCREEN))},
                onNavigateToProgressScreen = {navController.navigate((routes.PROGRESSSCREEN))},
                onNavigateToHomeScreen = {navController.navigate((routes.HOMESCREEN))},
                tokenPreferences = tokenPreferences
            )
        }
        composable(routes.ABOUTUSSCREEN){
            AboutUsScreen(
                onNavigateToUserProfileScreen = {navController.navigate((routes.USERPROFILESCREEN))}
            )
        }
    }
}