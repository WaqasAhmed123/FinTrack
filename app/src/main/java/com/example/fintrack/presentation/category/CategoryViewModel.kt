package com.example.fintrack.presentation.category

import androidx.compose.runtime.mutableStateListOf
import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : BaseViewModel() {
    var categoriesList = mutableStateListOf(
        "Food", "Transport", "Medicine", "Groceries", "Rent", "Gifts", "Entertainment"
    )

    fun addCategory(categoryName: String) {
        categoriesList.add(categoryName)
    }
}