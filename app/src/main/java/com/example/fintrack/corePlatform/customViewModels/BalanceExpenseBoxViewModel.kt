package com.example.fintrack.corePlatform.customViewModels

import androidx.lifecycle.viewModelScope
import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.useCases.StatementUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BalanceExpenseBoxViewModel @Inject constructor(private val statementUseCase: StatementUseCase) :
    BaseViewModel() {

    private val _dataModel = MutableStateFlow<Statement?>(null)
    val dataModel: StateFlow<Statement?>
        get() = _dataModel

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
}