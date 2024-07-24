package com.example.fintrack.corePlatform.globals.common.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.fintrack.corePlatform.globals.callbacks.IBaseError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

//@HiltViewModel
open class BaseViewModel : ViewModel(), IBaseError {

    protected val _showError = MutableStateFlow(false)
    private val _showNetworkError = MutableStateFlow(false)
    protected val _showProgress = MutableStateFlow(false)

    val showError: StateFlow<Boolean>
        get() = _showError

    val showNetworkError: StateFlow<Boolean>
        get() = _showNetworkError

    val showProgress: StateFlow<Boolean>
        get() = _showProgress

    override fun onNetworkError() {
        _showProgress.value = false
        _showNetworkError.value = true
        Log.d("overrideCalled","${showProgress.value} and showNetErr ${showNetworkError.value}")
    }

    override fun onFailure(message: String?) {
        _showProgress.value = false
        _showError.value = true
        Log.d("overrideCalled","${showProgress.value} and showErr ${showError.value}")
    }
}
