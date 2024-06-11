package com.example.fintrack.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _navigateToNextScreen = MutableStateFlow(false)
    val navigateToNextScreen: StateFlow<Boolean> get() = _navigateToNextScreen

    init {
        viewModelScope.launch {
            delay(3000) // Delay for 3 seconds
            _navigateToNextScreen.value = true // Trigger navigation
        }
    }
}