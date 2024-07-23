package com.example.fintrack.corePlatform.customViewModels

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import com.example.fintrack.corePlatform.utilities.ConnectionState
import com.example.fintrack.corePlatform.utilities.observeConnectivityAsFlow
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.useCases.StatementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Delay
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BalanceExpenseBoxViewModel @Inject constructor(private val statementUseCase: StatementUseCase, @ApplicationContext private val context: Context,) :
    BaseViewModel() {

    private var isDataLoaded = false
    private val _dataModel = MutableStateFlow<Statement?>(null)
    val dataModel: StateFlow<Statement?>
        get() = _dataModel

    init {
        observeNetworkConnectivity()
//        callApi()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun observeNetworkConnectivity() {
        val context = // Obtain the context in a suitable way
            viewModelScope.launch {
                context.observeConnectivityAsFlow().collect { connectionState ->
                    if (connectionState == ConnectionState.Available && !isDataLoaded) {
                        callApi()
                    }
                }
            }
    }

    fun callApi() {
        _showProgress.value = true
        viewModelScope.launch {
            try {
                val statement =
                    statementUseCase.callStatementApi(userId = "54eff5d9-5e9b-433d-8d74-8cddd4ed1cc0",
                        callback = object : IResponseCallback<Statement> {
                            override fun onSuccess(result: Statement?) {
                                isDataLoaded = true
                                _dataModel.value = result
                                    _showProgress.value = false
                            }

                            override fun onNetworkError() {
                                _showProgress.value = false
                                _showError.value = true

                            }

                            override fun onFailure(message: String?) {
                                _showProgress.value = false
                                _showError.value = true
                            }

                        }) // Make sure this method exists and returns a Statement
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

}