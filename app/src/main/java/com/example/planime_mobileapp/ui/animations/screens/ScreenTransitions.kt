package com.example.planime_mobileapp.ui.animations.screens

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

    val enterScaleFromCenter: EnterTransition = scaleIn(
        initialScale = 0.3f,
        animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing)
    ) + fadeIn(
        animationSpec = tween(durationMillis = 550)
    )

    val exitScaleToCenter: ExitTransition = scaleOut(
        targetScale = 0.3f,
        animationSpec = tween(durationMillis = 600)
    ) + fadeOut(
        animationSpec = tween(durationMillis = 550)
    )

    val enterFromTop: EnterTransition = slideInVertically(
        initialOffsetY = { -it },
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        animationSpec = tween(durationMillis = 300)
    )

    val exitToBottom: ExitTransition = slideOutVertically(
        targetOffsetY = { it },
        animationSpec = tween(
            durationMillis = 450,
            easing = FastOutSlowInEasing
        )
    ) + fadeOut(
        animationSpec = tween(durationMillis = 300)
    )
}