package com.example.fintrack.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.InputField
import com.example.fintrack.corePlatform.customViews.InputFieldHeading
import com.example.fintrack.corePlatform.customViews.NotificationIcon
import com.example.fintrack.corePlatform.customViews.PeriodSelectionTab
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.SubmitButton
import com.example.fintrack.presentation.components.BalanceExpenseBox
import com.example.fintrack.presentation.signup.TextFieldData
import com.example.fintrack.presentation.splash.SplashViewModel
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
                    ) {
                        PeriodSelectionTab(
                            selectedTabIndex = viewModel.selectedTabIndex.value,
                            onTabSelected = { index -> viewModel.selectedTabIndex.value = index },
                            tabItems = viewModel.tabItems)

                    }
                }
            }
        }
    }
}


