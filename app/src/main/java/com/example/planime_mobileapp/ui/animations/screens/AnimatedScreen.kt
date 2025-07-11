package com.example.planime_mobileapp.ui.animations.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun AnimatedScreen(
    visible: Boolean = true,
    enter: EnterTransition = ScreenTransitions.enterScreen,
    exit: ExitTransition = ScreenTransitions.exitScreen,
    content: @Composable () -> Unit
) {
    var shouldAnimate by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        shouldAnimate = true
    }

    AnimatedVisibility(
        visible = visible && shouldAnimate,
        enter = enter,
        exit = exit
    ) {
        content()
    }
}