package com.example.fintrack.presentation.customViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.fintrack.R

@Composable
fun TitleRow(title: String, onBackPressClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Image(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(
                id = R.string.back
            ),
            modifier = Modifier
                .size(30.dp)
                .clickable { onBackPressClick() },
            colorFilter = ColorFilter.tint(Color.White)

        )

        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall,
        )

        NotificationIcon()

    }
}