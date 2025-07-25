package com.example.planime_mobileapp.ui.components.visual

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.planime_mobileapp.ui.theme.fontFamilyGoogle

@Composable
fun DetailItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    labelFontSize: androidx.compose.ui.unit.TextUnit = 16.sp,
    valueFontSize: androidx.compose.ui.unit.TextUnit = 18.sp
) {
    Column(
        modifier = modifier
            .padding(vertical = 12.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Divider(
            color = Color.Black,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            color = Color.Black,
            fontSize = labelFontSize,
            fontFamily = fontFamilyGoogle,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.White,
                    offset = Offset(2f, 2f),
                    blurRadius = 0f
                )
            )
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = Color.Black,
            fontSize = valueFontSize,
            fontFamily = fontFamilyGoogle
        )
    }
}