package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun AddExpenseButton(
    color: Color = MaterialTheme.colorScheme.primary, onClick: () -> Unit, buttonTitle: String, modifier: Modifier
) {
    Button(modifier = modifier
        .width(150.dp)
        .clip(RoundedCornerShape(14.dp))
        .background(
            color = color, shape = RoundedCornerShape(14.dp)
        ), onClick = { onClick() }) {

        Text(
            text = buttonTitle,
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.SemiBold)
        )

    }
}