package com.example.fintrack.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.TransactionEntry

@Composable
fun DailyContent(){
    Column {
        TransactionEntry(
            imageResource = R.drawable.ic_salary,
            expenseType = "Salary" ,
            timeAndDate = "14-apr",
            expenseDuration = "MOnthly",
            price = "$20"
        )
    }

}