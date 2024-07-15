package com.example.fintrack.presentation.home

import TabItem
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.useCases.StatementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val statementUseCase: StatementUseCase) :
    BaseViewModel() {

    private val _dataModel = MutableStateFlow<Statement?>(null)
    val dataModel: StateFlow<Statement?>
        get() = _dataModel

//    fun fetchStatement() {
    init {


        viewModelScope.launch {
            try {
                val statement =
                    statementUseCase.callStatementApi(userId = "0c322761-e6b0-4988-a731-d30493e6335a",
                        callback = object : IResponseCallback<Statement> {
                            override fun onSuccess(result: Statement?) {
                                _dataModel.value = result
                            }

                            override fun onNetworkError() {
                            }

                            override fun onFailure(message: String?) {
                            }

                        }) // Make sure this method exists and returns a Statement
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
//    }

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