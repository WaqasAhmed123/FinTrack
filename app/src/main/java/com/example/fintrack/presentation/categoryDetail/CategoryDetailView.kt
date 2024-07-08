package com.example.fintrack.presentation.categoryDetail

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.AddExpenseButton
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.TitleRow
import com.example.fintrack.corePlatform.customViews.TransactionEntry
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun CategoryDetailView(
    navController: NavController,
    category: String,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {

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
                        .fillMaxHeight(0.3f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ProvideSpace(height = 0.06f)

                        TitleRow(title = category, onBackPressClick = {})

                        ProvideSpace(height = 0.06f)

                        BalanceExpenseBox(usagePercentage = 0.465f)
                    }

                }

                // Lower section

                BackgroundContainer() {

                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
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

                        //below add expenses button
                        AddExpenseButton(
                            onClick = { /*TODO*/ },
                            buttonTitle = stringResource(id = R.string.add_expenses),
                            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the button horizontally
                        )

                    }
                }
            }
        }
    }

}