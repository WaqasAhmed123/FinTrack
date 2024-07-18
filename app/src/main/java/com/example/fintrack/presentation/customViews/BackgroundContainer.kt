package com.example.fintrack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BackgroundContainer(
    heightPercentage: Float = 1f, // Default height as 70% of the parent
    content: @Composable BoxScope.() -> Unit
//    color: Color = Color.White // Default background color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(heightPercentage) // Convert percentage to dp
            .background(
                color = MaterialTheme.colorScheme.inversePrimary, // Use default color
                shape = RoundedCornerShape(topStartPercent = 10, topEndPercent = 10)
            ),
        content = content // Use content as children inside the Box
    )
}
