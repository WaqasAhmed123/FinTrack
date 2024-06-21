package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryBox(height : Int = 97 , width : Int = 105, category : String = ""){
    Box(
        modifier = Modifier
            .height(height.dp)
            .width(width.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(MaterialTheme.colorScheme.outline)
    ){
        Text(text = category, style = MaterialTheme.typography.labelMedium.copy(color = Color.White))

    }
}