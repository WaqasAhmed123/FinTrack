package com.example.fintrack.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.fintrack.corePlatform.customViews.TransactionEntry
import com.example.fintrack.corePlatform.globals.common.dataClasses.Transaction

@Composable
fun TabWiseContentHome(
    isDaily: Boolean = false,
    isWeekly: Boolean = false,
    isMonthly: Boolean = false
) {
    val transactions = when {
        isDaily -> generateDailyTransactions()
        isWeekly -> generateWeeklyTransactions()
        isMonthly -> generateMonthlyTransactions()
        else -> listOf()
    }

    LazyColumn {
        items(transactions) { transaction ->
            TransactionEntry(
                expenseType = transaction.expenseType,
                timeAndDate = transaction.timeAndDate,
                expenseDuration = transaction.expenseDuration,
                price = transaction.price
            )
        }
    }
}

fun generateDailyTransactions(): List<Transaction> {
    return listOf(
        Transaction("Food", "09-jul-2024", "Daily", "$20"),
        Transaction("Grocery", "09-jul-2024", "Daily", "$50"),
        Transaction("Fare", "09-jul-2024", "Daily", "$15")
        // Add more entries if needed
    )
}

fun generateWeeklyTransactions(): List<Transaction> {
    return listOf(
        Transaction("Food", "02-jul-2024", "Weekly", "$20"),
        Transaction("Grocery", "03-jul-2024", "Weekly", "$50"),
        Transaction("Fare", "04-jul-2024", "Weekly", "$15"),
        Transaction("Sports", "05-jul-2024", "Weekly", "$30"),
        Transaction("Utilities", "06-jul-2024", "Weekly", "$40"),
        Transaction("Health", "07-jul-2024", "Weekly", "$10"),
        Transaction("Misc", "08-jul-2024", "Weekly", "$25")
        // Add more entries if needed
    )
}

fun generateMonthlyTransactions(): List<Transaction> {
    return listOf(
        Transaction("Rent", "01-jul-2024", "Monthly", "$500"),
        Transaction("Salary", "05-jul-2024", "Monthly", "$3000"),
        Transaction("Topup", "10-jul-2024", "Monthly", "$15"),
        Transaction("Fuel", "15-jul-2024", "Monthly", "$50"),
        Transaction("Misc", "20-jul-2024", "Monthly", "$200"),
        Transaction("Savings", "25-jul-2024", "Monthly", "$100"),
        Transaction("Loan", "30-jul-2024", "Monthly", "$250")
        // Add more entries if needed
    )
}
