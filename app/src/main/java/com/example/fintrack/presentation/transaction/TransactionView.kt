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

                        TotalBalanceBox(amount = "465456")

                        //ProvideSpace(height = 0.06f)
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            IncomeExpenseBoxImpTransaction(amount = "465156",
                                isIncome = true,
                                onClick = {})
                            IncomeExpenseBoxImpTransaction(amount = "465156",
                                isIncome = false,
                                onClick = {})
                        }
                    }

                }

                // Lower section

                BackgroundContainer() {


                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        TransactionEntry(
                            //imageResource = R.drawable.ic_salary,
                            expenseType = "Salary",
                            timeAndDate = "14-apr",
                            expenseDuration = "Yearly",
                            price = "$20"
                        )
                        TransactionEntry(
                            //imageResource = R.drawable.ic_salary,
                            expenseType = "Salary",
                            timeAndDate = "14-apr",
                            expenseDuration = "Monthly",
                            price = "$20"
                        )
                        TransactionEntry(
                            //imageResource = R.drawable.ic_salary,
                            expenseType = "Salary",
                            timeAndDate = "14-apr",
                            expenseDuration = "Monthly",
                            price = "$200000000000000"
                        )


                    }
                }
            }
        }
    }

}