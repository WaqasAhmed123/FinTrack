package com.example.fintrack.presentation.category

import com.example.fintrack.corePlatform.globals.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor() : BaseViewModel() {
    val categoriesList = listOf(
        "Food", "Transport", "Medicine", "Groceries", "Rent", "Gifts", "Entertainment"
    )
}