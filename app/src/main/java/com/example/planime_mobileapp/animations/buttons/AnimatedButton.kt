package com.example.planime_mobileapp.animations.buttons

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun Modifier.animateButtonInteraction(
    isPressed: Boolean,
    isHovered: Boolean = false
): Modifier = composed {
    val scale by animateFloatAsState(
        targetValue = ButtonTransitions.pressAnimation(isPressed),
        animationSpec = tween(durationMillis = 100)
    )

    val elevation by animateDpAsState(
        targetValue = ButtonTransitions.hoverAnimation(isHovered),
        animationSpec = tween(durationMillis = 100)
    )

    this.then(
        Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
            }
            .shadow(elevation)
    )
}