package com.example.planime_mobileapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun CreatePlanTextField(tittle: String) {

    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = {
            Text(
                tittle,
                style = TextStyle(fontFamily = fontFamilyGoogle),
                fontSize = 20.sp,
            )
        },
        placeholder = {
            Text(
                "Escribe aquí",
                style = TextStyle(fontFamily = fontFamilyGoogle),
                fontSize = 20.sp,
                color = Color.White
            )
        },
        modifier = Modifier
            .width(350.dp)
            .padding(bottom = 20.dp)
            .background(
                color = Color(0xFFFF8282),
                shape = RoundedCornerShape(12.dp)
            )
            .drawWithContent {
                drawContent()
                drawIntoCanvas { canvas ->
                    val paint = Paint().apply {
                        color = Color.Black.copy(alpha = 0.2f)
                        this.asFrameworkPaint().apply {
                            isAntiAlias = true
                            maskFilter = android.graphics.BlurMaskFilter(8f, android.graphics.BlurMaskFilter.Blur.NORMAL)
                        }
                    }

                    val shadowHeight = 4.dp.toPx()
                    val cornerRadius = 12.dp.toPx()
                    val shadowWidthReduction = 7.dp.toPx()

                    canvas.drawRoundRect(
                        left = shadowWidthReduction,
                        top = size.height - shadowHeight,
                        right = size.width - shadowWidthReduction,
                        bottom = size.height,
                        radiusX = cornerRadius,
                        radiusY = cornerRadius,
                        paint = paint
                    )
                }
            },
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            focusedLabelColor = Color.Black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        )
    )
}