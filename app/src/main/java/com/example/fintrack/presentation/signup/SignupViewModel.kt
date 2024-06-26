package com.example.fintrack.presentation.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import com.example.fintrack.R
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(): BaseViewModel() {

//    data class TextFieldData(
//        val value: MutableState<TextFieldValue>,
//        val placeholder: String
//    )




//    enum class TextfieldValues {
//        FULL_NAME,
//        EMAIL,
//        MOBILE_NUMBER,
//        PASSWORD,
//        CONFIRM_PASSWORD
//    }

enum class TextfieldValues(val placeholder: String, val isPassword: Boolean = false) {
    FULL_NAME("Full Name"),
    EMAIL("Email"),
    MOBILE_NUMBER("Mobile Number"),
    PASSWORD("Password", true),
    CONFIRM_PASSWORD("Confirm Password", true)
}


}