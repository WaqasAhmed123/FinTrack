package com.example.fintrack.presentation.addExpenses

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.AddExpenseButton
import com.example.fintrack.corePlatform.customViews.InputField
import com.example.fintrack.corePlatform.customViews.InputFieldHeading
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.TitleRow
import com.example.fintrack.corePlatform.customViews.TransactionEntry
import com.example.fintrack.corePlatform.globals.common.textfield.TextFieldData
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun AddExpensesView(
    navController: NavController, viewModel: AddExpensesViewModel = hiltViewModel()
) {

    //textfield values
    val date = remember { mutableStateOf(TextFieldValue("")) }
    val amount = remember { mutableStateOf(TextFieldValue("")) }
    val expenseTitle = remember { mutableStateOf(TextFieldValue("")) }
    val expenseDescription = remember { mutableStateOf(TextFieldValue("")) }

    //rendering textfields using lazycol
    val textFieldValues: Map<String, TextFieldData> = mapOf(
        stringResource(id = R.string.date) to TextFieldData(
            date, stringResource(id = R.string.example_full_name)
        ), stringResource(id = R.string.amount) to TextFieldData(
            amount, stringResource(id = R.string.example_email)
        ), stringResource(id = R.string.expense_title) to TextFieldData(
            expenseTitle, stringResource(id = R.string.example_mobile_number)
        ), stringResource(id = R.string.enter_message) to TextFieldData(
            expenseDescription, ""
        )
    )


    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                // Upper section

                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxHeight(0.1f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ProvideSpace(height = 0.06f)

                        TitleRow(title = stringResource(id = R.string.add_expenses),
                            onBackPressClick = {})

                        ProvideSpace(height = 0.06f)

                    }

                }

                // Lower section

                BackgroundContainer() {

                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        LazyColumn(modifier = Modifier.fillMaxWidth()) {
                            items(textFieldValues.size) { index ->
                                val key = textFieldValues.keys.elementAt(index)
                                val textFieldData = textFieldValues[key]!!
                                InputFieldHeading(text = key)
                                InputField(
                                    value = textFieldData.value.value,
                                    onValueChange = { newValue ->
                                        textFieldData.value.value = newValue
                                    },
                                    placeholder = textFieldData.placeholder,
                                    isDate = when (index) {
                                        0 -> true
                                        else -> {
                                            false
                                        }
                                    },
                                    isSingleLine = when (index) {
                                        3 -> false
                                        else -> {
                                            true
                                        }
                                    }

                                )
                            }
                        }

                        ProvideSpace(height = 0.06f)

                        //below add expenses button
                        AddExpenseButton(
                            onClick = { /*TODO*/ },
                            buttonTitle = stringResource(id = R.string.save),
                            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the button horizontally
                        )

                    }
                }
            }
        }
    }
}