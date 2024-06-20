package com.example.fintrack.presentation.analysis

import androidx.compose.runtime.mutableStateOf
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnalysisViewModel @Inject constructor() :BaseViewModel() {

    val selectedTabIndex = mutableStateOf(0)

    // Define your tabs and their content
//    val tabItems = listOf(
//        TabItem("Daily", { DailyContent() }),
//        TabItem("Weekly", { WeeklyContent() }),
//        TabItem("Monthly", { MonthlyContent() }),
//        TabItem("Yearly", { YearlyContent() })
//    )

    val tabsTitles = listOf(
        "Daily",
        "Weekly",
        "Monthly",
        "Yearly"
    )

}