package com.example.fintrack.domain.model

data class Statement(
    val expensePercentage: Double,
    val totalBalance: Int,
    val totalExpense: Int,
    val totalIncome: Int
)