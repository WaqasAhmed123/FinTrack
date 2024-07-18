package com.example.fintrack.presentation.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun IncomeExpenseBoxImpTransaction(isIncome : Boolean = false , amount : String, onClick:()-> Unit){
    Box (modifier = Modifier
//        .fillMaxWidth(0.5f)
        .width(160.dp)
        .height(101.dp)
        .clip(RoundedCornerShape(14.dp))
        .background(MaterialTheme.colorScheme.inversePrimary),
        contentAlignment = Alignment.Center){
        IncomeExpenseBox(amount = amount , isIncome = isIncome)
    }
}