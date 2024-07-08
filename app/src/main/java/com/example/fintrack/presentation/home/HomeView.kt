package com.example.fintrack.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.PeriodSelectionTab
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun HomeView(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

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
                            Text(
                                text = "${stringResource(id = R.string.hi)}, ${
                                    stringResource(
                                        id = R.string.welcome_back
                                    )
                                }",
                                style = MaterialTheme.typography.titleSmall,
                                modifier = Modifier.weight(1f)
                            )

                            NotificationIcon()


                        }

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
                        PeriodSelectionTab(
                            selectedTabIndex = viewModel.selectedTabIndex.value,
                            onTabSelected = { index -> viewModel.selectedTabIndex.value = index },
                            tabsTitles = viewModel.tabsTitles
                        )

                        when (viewModel.selectedTabIndex.value) {
                            0 -> TabWiseContentHome(isDaily = true)
                            1 -> TabWiseContentHome(isWeekly = true)
                            2 -> TabWiseContentHome(isMonthly = true)
                        }

                    }
                }
            }
        }
    }
}


