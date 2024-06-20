package com.example.fintrack.corePlatform.customViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TransactionEntry(
    imageResource: Int,
    expenseType: String,
    timeAndDate: String,
    expenseDuration: String,
    price: String,
    isDebit: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical =  16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(53.dp)
                .width(57.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(MaterialTheme.colorScheme.outline)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .height(23.48.dp)
                    .width(26.dp)
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = expenseType, style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = timeAndDate,
                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.outline),
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp), color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = expenseDuration,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Normal),
            modifier = Modifier.weight(1f)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Divider(
            modifier = Modifier
                .height(40.dp)
                .width(1.dp), color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = price,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.labelMedium,
            color = if (isDebit) MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.outline
        )
    }
}
