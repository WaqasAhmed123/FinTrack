package com.example.fintrack.presentation.customViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fintrack.R

@Composable
fun IncomeExpenseBox(isIncome: Boolean = false, amount : String) {
    Box() {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Image(
                painter = painterResource(id = if (isIncome) R.drawable.ic_income else R.drawable.ic_expense),
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    if (isIncome) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
                ),
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
            )
            Text(
                text = stringResource(id = if (isIncome) R.string.income else R.string.expense),
                style = MaterialTheme.typography.headlineSmall
            )
            Text (text = amount,
            style = MaterialTheme.typography.labelMedium.copy(color = if (isIncome)MaterialTheme.colorScheme.scrim else MaterialTheme.colorScheme.outline),
            )
        }
    }
}