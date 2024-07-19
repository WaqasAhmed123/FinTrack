package com.example.fintrack.corePlatform.utilities

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun ShowToast(context: Context, text: String){
    Toast.makeText(context,text, Toast.LENGTH_SHORT).show()
}