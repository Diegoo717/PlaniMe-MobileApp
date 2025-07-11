package com.example.planime_mobileapp.ui.components.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.times
import kotlin.math.abs
import kotlin.math.sqrt

data class WeightRecord(
    val date: String,
    val weight: Float,
    val isGoal: Boolean = false
)

@Composable
fun WeightProgressChart(
    records: List<WeightRecord>,
    goalWeight: Float,
    modifier: Modifier = Modifier,
    chartHeight: Dp = 250.dp,
    targetLineColor: Color = Color(0xFFFF6B6B),
    lineColor: Color = Color(0xFF4CAF50),
    pointColor: Color = Color(0xFF2196F3),
    axisColor: Color = Color(0xFF666666),
    showDatesBelow: Boolean = true,
) {
    if (records.isEmpty()) return

    val minWeight = (records.minOf { it.weight }.coerceAtMost(goalWeight) - 5).toInt().toFloat()
    val maxWeight = (records.maxOf { it.weight }.coerceAtLeast(goalWeight) + 5).toInt().toFloat()
    val weightRange = maxWeight - minWeight
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()
    var selectedPointIndex by remember { mutableStateOf<Int?>(null) }

    val minPointSpacing = 30.dp
    val yAxisWidth = 50.dp
    val chartPadding = 16.dp

    val chartAreaWidth = if (records.size > 1) {
        (records.size - 1) * minPointSpacing + (chartPadding * 2)
    } else {
        200.dp
    }

    val totalWidth = yAxisWidth + chartAreaWidth

    Column(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .width(totalWidth)
            .height(if (showDatesBelow) 350.dp else 300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .width(yAxisWidth)
                    .height(chartHeight),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                val weightLabels = (0..4).map { i ->
                    maxWeight - (i * (weightRange / 4))
                }

                weightLabels.forEach { weight ->
                    Text(
                        text = "${weight.toInt()}kg",
                        style = TextStyle(
                            fontSize = 10.sp,
                            color = axisColor
                        ),
                        modifier = Modifier.padding(end = 4.dp)
                    )
                }
            }

            Column {
                Canvas(
                    modifier = Modifier
                        .height(chartHeight)
                        .width(chartAreaWidth)
                        .padding(horizontal = chartPadding)
                        .then(
                            if (!showDatesBelow) {
                                Modifier.pointerInput(Unit) {
                                    detectTapGestures { offset ->
                                        val chartWidth = size.width.toFloat()
                                        val chartHeight = size.height.toFloat()
                                        val xScale = if (records.size > 1) chartWidth / (records.size - 1) else 0f
                                        val yScale = chartHeight / weightRange

                                        val pathPoints = records.mapIndexed { index, record ->
                                            Offset(
                                                x = index * xScale,
                                                y = chartHeight - (record.weight - minWeight) * yScale
                                            )
                                        }

                                        val touchRadius = with(density) { 25.dp.toPx() }
                                        val closestPoint = pathPoints.mapIndexed { index, point ->
                                            val distance = sqrt(
                                                (point.x - offset.x) * (point.x - offset.x) +
                                                        (point.y - offset.y) * (point.y - offset.y)
                                            )
                                            index to distance
                                        }.minByOrNull { it.second }

                                        if (closestPoint != null && closestPoint.second <= touchRadius) {
                                            selectedPointIndex = if (selectedPointIndex == closestPoint.first) null else closestPoint.first
                                        }
                                    }
                                }
                            } else Modifier
                        )
                ) {
                    val chartWidth = size.width
                    val chartHeight = size.height
                    val yScale = chartHeight / weightRange
                    val xScale = if (records.size > 1) chartWidth / (records.size - 1) else 0f

                    val goalY = chartHeight - (goalWeight - minWeight) * yScale
                    drawLine(
                        color = targetLineColor,
                        start = Offset(0f, goalY),
                        end = Offset(chartWidth, goalY),
                        strokeWidth = 3.dp.toPx()
                    )

                    val goalTextStyle = TextStyle(
                        fontSize = 12.sp,
                        color = targetLineColor,
                        fontWeight = FontWeight.Bold
                    )
                    val goalTextResult = textMeasurer.measure(
                        text = "Objetivo",
                        style = goalTextStyle
                    )
                    drawText(
                        textLayoutResult = goalTextResult,
                        topLeft = Offset(
                            -55.dp.toPx(),
                            goalY - goalTextResult.size.height / 2
                        )
                    )

                    for (i in 0..4) {
                        val y = (chartHeight / 4) * i
                        drawLine(
                            color = axisColor.copy(alpha = 0.3f),
                            start = Offset(0f, y),
                            end = Offset(chartWidth, y),
                            strokeWidth = 1.dp.toPx()
                        )
                    }

                    records.forEachIndexed { index, _ ->
                        val x = index * xScale
                        drawLine(
                            color = axisColor.copy(alpha = 0.3f),
                            start = Offset(x, 0f),
                            end = Offset(x, chartHeight),
                            strokeWidth = 1.dp.toPx()
                        )
                    }

                    val pathPoints = records.mapIndexed { index, record ->
                        Offset(
                            x = index * xScale,
                            y = chartHeight - (record.weight - minWeight) * yScale
                        )
                    }

                    if (pathPoints.size > 1) {
                        val path = androidx.compose.ui.graphics.Path()
                        path.moveTo(pathPoints[0].x, pathPoints[0].y)

                        for (i in 1 until pathPoints.size) {
                            val prev = pathPoints[i - 1]
                            val curr = pathPoints[i]
                            val controlPoint1 = Offset(prev.x + (curr.x - prev.x) * 0.5f, prev.y)
                            val controlPoint2 = Offset(curr.x - (curr.x - prev.x) * 0.5f, curr.y)
                            path.cubicTo(controlPoint1.x, controlPoint1.y, controlPoint2.x, controlPoint2.y, curr.x, curr.y)
                        }

                        drawPath(
                            path = path,
                            color = lineColor,
                            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 4.dp.toPx())
                        )
                    }

                    pathPoints.forEachIndexed { index, point ->
                        val isSelected = selectedPointIndex == index
                        val circleRadius = if (isSelected) 8.dp.toPx() else 6.dp.toPx()
                        val innerRadius = if (isSelected) 6.dp.toPx() else 4.dp.toPx()

                        drawCircle(
                            color = Color.White,
                            radius = circleRadius,
                            center = point
                        )
                        drawCircle(
                            color = if (isSelected) Color(0xFFFF9800) else pointColor,
                            radius = innerRadius,
                            center = point
                        )
                    }

                    if (showDatesBelow) {
                        pathPoints.forEachIndexed { index, point ->
                            val record = records[index]
                            val formattedDate = try {
                                when {
                                    record.date.length >= 5 -> record.date.substring(0, 5)
                                    else -> record.date
                                }
                            } catch (e: Exception) {
                                "N/A"
                            }

                            val textStyle = TextStyle(
                                fontSize = 10.sp,
                                color = axisColor
                            )

                            val textLayoutResult = textMeasurer.measure(
                                text = formattedDate,
                                style = textStyle
                            )

                            rotate(degrees = -45f, pivot = Offset(point.x, point.y + 25.dp.toPx())) {
                                drawText(
                                    textLayoutResult = textLayoutResult,
                                    topLeft = Offset(
                                        point.x - textLayoutResult.size.width / 2,
                                        point.y + 25.dp.toPx()
                                    )
                                )
                            }
                        }
                    }

                    if (!showDatesBelow && selectedPointIndex != null) {
                        val index = selectedPointIndex!!
                        val point = pathPoints[index]
                        val record = records[index]

                        val tooltipWidth = 120.dp.toPx()
                        val tooltipHeight = 50.dp.toPx()
                        val tooltipX = (point.x - tooltipWidth / 2).coerceIn(0f, chartWidth - tooltipWidth)
                        val tooltipY = (point.y - tooltipHeight - 15.dp.toPx()).coerceAtLeast(0f)

                        drawRoundRect(
                            color = Color.Black.copy(alpha = 0.8f),
                            topLeft = Offset(tooltipX, tooltipY),
                            size = androidx.compose.ui.geometry.Size(tooltipWidth, tooltipHeight),
                            cornerRadius = androidx.compose.ui.geometry.CornerRadius(8.dp.toPx())
                        )

                        val dateTextStyle = TextStyle(
                            fontSize = 12.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        val dateTextResult = textMeasurer.measure(
                            text = record.date,
                            style = dateTextStyle
                        )
                        drawText(
                            textLayoutResult = dateTextResult,
                            topLeft = Offset(
                                tooltipX + 10.dp.toPx(),
                                tooltipY + 8.dp.toPx()
                            )
                        )

                        val weightTextStyle = TextStyle(
                            fontSize = 11.sp,
                            color = Color.White
                        )
                        val weightTextResult = textMeasurer.measure(
                            text = "${record.weight}kg",
                            style = weightTextStyle
                        )
                        drawText(
                            textLayoutResult = weightTextResult,
                            topLeft = Offset(
                                tooltipX + 10.dp.toPx(),
                                tooltipY + 28.dp.toPx()
                            )
                        )
                    }
                }

                if (showDatesBelow) {
                    Spacer(modifier = Modifier.height(30.dp))
                }
            }
        }

        if (!showDatesBelow) {
            Text(
                text = "💡 Toca los puntos para ver las fechas",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = axisColor,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            LegendItem(color = lineColor, text = "Tu peso")
            LegendItem(color = targetLineColor, text = "Objetivo: ${goalWeight.toInt()}kg")
        }
    }
}

@Composable
private fun LegendItem(color: Color, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}