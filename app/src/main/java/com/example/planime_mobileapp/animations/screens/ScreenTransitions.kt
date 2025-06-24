package com.example.planime_mobileapp.animations.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween

object ScreenTransitions {

    val enterScreen: EnterTransition = slideInHorizontally(
        initialOffsetX = { it },
        animationSpec = tween(durationMillis = 350, easing = FastOutSlowInEasing)
    ) + fadeIn(
        animationSpec = tween(durationMillis = 300, delayMillis = 50)
    )

    val exitScreen: ExitTransition = slideOutHorizontally(
        targetOffsetX = { -it },
        animationSpec = tween(durationMillis = 350)
    ) + fadeOut(
        animationSpec = tween(durationMillis = 300)
    )
}