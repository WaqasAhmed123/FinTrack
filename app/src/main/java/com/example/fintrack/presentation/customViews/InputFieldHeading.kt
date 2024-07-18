package com.example.fintrack.presentation.customViews

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun InputFieldHeading(text:String){
    Text(text = text, style = MaterialTheme.typography.bodySmall)

}