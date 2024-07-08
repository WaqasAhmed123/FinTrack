package com.example.fintrack.domain.model

data class TransactionList(
    val amount: Int,
    val categoryName: String,
    val date: String,
    val description: String,
    val isIncome: Boolean,
    val title: String,
    val transactionId: Int
)