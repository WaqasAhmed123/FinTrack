package com.example.fintrack.presentation.customViews

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable

fun SubmitButton(
    onClick: () -> Unit,
    buttonTitle: String,
    isLoading: StateFlow<Boolean>? = null,
    buttonWidth: Float = 0.5f,
    color: Color = MaterialTheme.colorScheme.primary
) {
//    if (isLoading != null) {
//        val isLoadingState by isLoading.collectAsState()
//
//    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(buttonWidth)
            .background(color = color, shape = RoundedCornerShape(41.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(41.dp),
    ) {
        if (isLoading?.value == true) {
            CircularProgressIndicator(color = Color.White)

        } else {
            Text(
                text = buttonTitle, style = MaterialTheme.typography.titleSmall
            )

        }

    }

}