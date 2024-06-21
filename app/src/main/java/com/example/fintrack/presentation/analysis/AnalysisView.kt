package com.example.fintrack.presentation.analysis

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
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.PeriodSelectionTab
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun AnalysisView(navController: NavController, viewModel: AnalysisViewModel = hiltViewModel()) {
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
                        Row {
                            Spacer(modifier = Modifier.weight(0.6f))
                            Text(
                                text = stringResource(
                                    id = R.string.analysis,
                                ),
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier.weight(1f),
                            )


                            NotificationIcon()

                        }

                        ProvideSpace(height = 0.06f)

                        BalanceExpenseBox()
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

                        //ProvideSpace(height = 0.07f)

                        PeriodSelectionTab(
                            selectedTabIndex = viewModel.selectedTabIndex.value,
                            onTabSelected = { index -> viewModel.selectedTabIndex.value = index },
                            tabsTitles = viewModel.tabsTitles
                        )

                        //ProvideSpace(height = 0.07f)
                        Spacer(modifier = Modifier.height(16.dp))


                        when (viewModel.selectedTabIndex.value) {
                            0 -> TabWiseContentAnalysis(isDaily = true)
                            1 -> TabWiseContentAnalysis(isWeekly = true)
                            2 -> TabWiseContentAnalysis(isMonthly = true)
                            3 -> TabWiseContentAnalysis(isYearly = true)
                        }

                        //ProvideSpace(height = 0.06f)
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceAround // Space between boxes
                        ) {
                            IncomeExpenseBox(isIncome = true, "54656")
                            IncomeExpenseBox(amount = "646")

                        }


                    }
                }
            }
        }
    }
}