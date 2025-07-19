package com.example.planime_mobileapp.ui.components.inputs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OwnDropdownProgress(
    tittle: String,
    options: List<String>,
    onSelectionChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = modifier
            .padding(bottom = 20.dp)
    ) {
        TextField(
            modifier = modifier
                .menuAnchor()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFF6B6B),
                            Color(0xFFFFD700)
                        )
                    ),
                    shape = RoundedCornerShape(12.dp)
                ).drawWithContent {
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
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            label = {
                Text(
                    tittle,
                    style = TextStyle(
                        fontFamily = fontFamilyGoogle,
                        fontSize = 20.sp
                    )
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
                focusedLabelColor = Color.DarkGray,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedTrailingIconColor = Color.Black,
                focusedTrailingIconColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(
                fontFamily = fontFamilyGoogle,
                fontSize = 20.sp,
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFFFF6B6B),
                            Color(0xFFFFD700)
                        )
                    )
                )
        ) {
            options.forEachIndexed { index, level ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = level,
                            style = TextStyle(
                                fontFamily = fontFamilyGoogle,
                                fontSize = 18.sp
                            )
                        )
                    },
                    onClick = {
                        selectedOption = level
                        expanded = false
                        onSelectionChanged(index)
                    }
                )
            }
        }
    }
}