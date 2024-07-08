package com.example.fintrack.domain.model

data class Statement(
    val expensePercentage: Int,
    val totalBalance: Int,
    val totalExpense: Int,
    val totalIncome: Int
)