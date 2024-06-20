package com.example.fintrack.presentation.home

import TabItem
import androidx.compose.runtime.mutableStateOf
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    val selectedTabIndex = mutableStateOf(0)

    // Define your tabs and their content
//    val tabItems = listOf(
//        TabItem("Daily", { DailyContent() }),
//        TabItem("Weekly", { WeeklyContent() }),
//        TabItem("Monthly", { MonthlyContent() }),
//    )
    val tabsTitles = listOf(
        "Daily",
        "Weekly",
        "Monthly",
    )
}