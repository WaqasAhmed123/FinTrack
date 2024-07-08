package com.example.fintrack.presentation.transaction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.IncomeExpenseBox
import com.example.fintrack.corePlatform.customViews.IncomeExpenseBoxImpTransaction
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.PeriodSelectionTab
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.TitleRow
import com.example.fintrack.corePlatform.customViews.TotalBalanceBox
import com.example.fintrack.corePlatform.customViews.TransactionEntry
import com.example.fintrack.corePlatform.globals.common.dataClasses.Transaction
import com.example.fintrack.presentation.analysis.AnalysisViewModel
import com.example.fintrack.presentation.analysis.TabWiseContentAnalysis
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun TransactionView(navController: NavController, viewModel: AnalysisViewModel = hiltViewModel()) {

    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                // Upper section

                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(0.38f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ProvideSpace(height = 0.045f)

                        TitleRow(title = stringResource(id = R.string.transaction), onBackPressClick = {})

                        //ProvideSpace(height = 0.06f)
                        Spacer(modifier = Modifier.height(16.dp))

                        TotalBalanceBox(amount = "534,544")

                        //ProvideSpace(height = 0.06f)
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IncomeExpenseBoxImpTransaction(amount = "1,000,000",
                                isIncome = true,
                                onClick = {})
                            IncomeExpenseBoxImpTransaction(amount = "465,156",
                                isIncome = false,
                                onClick = {})
                        }
                    }

                }

                // Lower section

                BackgroundContainer() {
                    val transactions = listOf( Transaction("Food", "09-jul-2024", "Daily", "$20"),
                        Transaction("Grocery", "09-jul-2024", "Daily", "$50"),
                        Transaction("Fare", "09-jul-2024", "Daily", "$15"),
                        Transaction("Food", "02-jul-2024", "Weekly", "$20"),
                        Transaction("Grocery", "03-jul-2024", "Weekly", "$50"),
                        Transaction("Fare", "04-jul-2024", "Weekly", "$15"),
                        Transaction("Sports", "05-jul-2024", "Weekly", "$30"),
                        Transaction("Utilities", "06-jul-2024", "Weekly", "$40"),
                        Transaction("Health", "07-jul-2024", "Weekly", "$10"),
                        Transaction("Misc", "08-jul-2024", "Weekly", "$25"),
                        Transaction("Rent", "01-jul-2024", "Monthly", "$500"),
                        Transaction("Salary", "05-jul-2024", "Monthly", "$3000"),
                        Transaction("Topup", "10-jul-2024", "Monthly", "$15"),
                        Transaction("Fuel", "15-jul-2024", "Monthly", "$50"),
                        Transaction("Misc", "20-jul-2024", "Monthly", "$200"),
                        Transaction("Savings", "25-jul-2024", "Monthly", "$100"),
                        Transaction("Loan", "30-jul-2024", "Monthly", "$250")

                    )


                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
//                            .verticalScroll(rememberScrollState())
                    ) {
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
                }
            }
        }
    }

}