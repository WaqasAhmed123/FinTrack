package com.example.fintrack.presentation.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fintrack.R

@Composable
fun NetworkError(onRetry: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Icon(
//                imageVector = Icons.Filled.Clear,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.error,
//                modifier = Modifier.size(64.dp)
//            )
//            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.network_error_occurred),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(8.dp))
//            Text(
//                text = stringResource(id = R.string.please_try_again),
//                style = MaterialTheme.typography.bodySmall,
//                color = MaterialTheme.colorScheme.onBackground
//            )
//            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onRetry) {
                Text(text = stringResource(id = R.string.retry))
            }
        }
    }
}
