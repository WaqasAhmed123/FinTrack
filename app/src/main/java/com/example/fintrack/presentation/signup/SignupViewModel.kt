package com.example.fintrack.presentation.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.viewModelScope
import com.example.fintrack.R
import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import com.example.fintrack.domain.model.Registration
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.model.dataModel.RegistrationRequest
import com.example.fintrack.domain.useCases.RegistrationUseCase
import com.example.fintrack.domain.useCases.StatementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(private val registrationUseCase: RegistrationUseCase) :
    BaseViewModel() {

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage
    private val _dataModel = MutableStateFlow<Registration?>(null)
    val dataModel: StateFlow<Registration?>
        get() = _dataModel

    fun register(
        data: RegistrationRequest,
        noInternetMessage: String,
        somethingWentWrongMessage: String
    ) {
        _showProgress.value = true
        viewModelScope.launch {
            try {
                registrationUseCase.callRegistrationApi(
                    data,
                    callback = object : IResponseCallback<Registration> {
                        override fun onSuccess(result: Registration?) {
                            _dataModel.value = result
                            viewModelScope.launch {
                                _showProgress.value = false
                            }
                        }

                        override fun onNetworkError() {
                            _showProgress.value = false
                            _errorMessage.value = noInternetMessage
//                                _showError.value = true

                        }

                        override fun onFailure(message: String?) {
                            _showProgress.value = false
                            _errorMessage.value = somethingWentWrongMessage
                        }

                    })
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }

    fun clearErrorMessage() {
        _errorMessage.value = null
    }

}