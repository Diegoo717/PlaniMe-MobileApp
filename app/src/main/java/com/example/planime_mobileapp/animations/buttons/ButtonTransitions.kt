package com.example.planime_mobileapp.animations.buttons

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object ButtonTransitions {
    val pressAnimation: (Boolean) -> Float = { isPressed ->
        if (isPressed) 0.70f else 1f
    }

    val hoverAnimation: (Boolean) -> Dp = { isHovered ->
        if (isHovered) 30.dp else 0.dp
    }
}