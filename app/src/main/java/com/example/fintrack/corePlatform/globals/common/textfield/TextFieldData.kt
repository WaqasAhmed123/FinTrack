package com.example.fintrack.corePlatform.globals.common.textfield

import androidx.compose.runtime.MutableState
import androidx.compose.ui.text.input.TextFieldValue

data class TextFieldData(
    val value: MutableState<TextFieldValue>, val placeholder: String
)
