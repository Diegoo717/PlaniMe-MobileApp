package com.example.planime_mobileapp.ui.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun OwnTextFieldCreatePlan(
    tittle: String,
    modifier: Modifier = Modifier,
    value: String = "",
    onValueChange: (String) -> Unit = {},
    errorMessage: String? = null
) {
    Column(modifier = modifier) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                .fillMaxWidth()
                .background(
                    color = if (errorMessage != null) Color(0xFFFFB3B3) else Color(0xFFFF8282),
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

        // Mostrar error si existe
        errorMessage?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                fontSize = 14.sp,
                fontFamily = fontFamilyGoogle,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}