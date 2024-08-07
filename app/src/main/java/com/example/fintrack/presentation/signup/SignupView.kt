package com.example.fintrack.presentation.signup

import android.health.connect.datatypes.units.Length
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.presentation.customViews.InputField
import com.example.fintrack.presentation.customViews.InputFieldHeading
import com.example.fintrack.presentation.customViews.ProvideSpace
import com.example.fintrack.presentation.customViews.SubmitButton
import com.example.fintrack.corePlatform.globals.common.textfield.TextFieldData
import com.example.fintrack.corePlatform.utilities.ShowToast
import com.example.fintrack.domain.model.dataModel.RegistrationRequest
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun SignupView(navController: NavController, viewModel: SignupViewModel = hiltViewModel()) {

    val context = LocalContext.current
    //textfield values
    val fullName = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val mobileNumber = remember { mutableStateOf(TextFieldValue("")) }
    val password = remember { mutableStateOf(TextFieldValue("")) }
    val confirmPassword = remember { mutableStateOf(TextFieldValue("")) }

    val noInternetMessage = stringResource(id = R.string.no_internet_connection)
    val somethingWentWrongMessage = stringResource(id = R.string.something_went_wrong)

    //rendering textfields using lazycol
    val textFieldValues: Map<String, TextFieldData> = mapOf(
        stringResource(id = R.string.full_name) to TextFieldData(
            fullName, stringResource(id = R.string.example_full_name)
        ), stringResource(id = R.string.email) to TextFieldData(
            email, stringResource(id = R.string.example_email)
        ), stringResource(id = R.string.mobile_number) to TextFieldData(
            mobileNumber, stringResource(id = R.string.example_mobile_number)
        ), stringResource(id = R.string.password) to TextFieldData(
            password, ""
        ), stringResource(id = R.string.confirm_password) to TextFieldData(
            confirmPassword, ""
        )
    )

    val isLoading by viewModel.showProgress.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    errorMessage?.let {
        ShowToast(context = context, text = it)
        viewModel.clearErrorMessage()
    }

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
                        .fillMaxHeight(0.2f)
                        .fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        ProvideSpace(height = 0.4f)
                        Text(
                            text = stringResource(id = R.string.create_account),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }

                // Lower section

                BackgroundContainer() {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
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
                                    isPassword = when (index) {
                                        3 -> true
                                        4 -> true

                                        else -> {
                                            false
                                        }
                                    }

                                )
                            }
                        }
                        ProvideSpace(height = 0.05f)

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {

                            SubmitButton(
                                onClick = {
                                    if (email.value.text.isNotEmpty() && fullName.value.text.isNotEmpty() && mobileNumber.value.text.isNotEmpty() && password.value.text.isNotEmpty() && confirmPassword.value.text.isNotEmpty()) {
                                        viewModel.register(
                                            data = RegistrationRequest(
                                                email = email.value.text,
                                                password = password.value.text,
                                                userName = fullName.value.text,
                                                mobile = mobileNumber.value.text
                                            ),
                                            noInternetMessage = noInternetMessage,
                                            somethingWentWrongMessage = somethingWentWrongMessage
                                        )
                                    } else {
                                        ShowToast(
                                            context = context, text = "Please fill all fields"
                                        )
                                    }

                                },
                                buttonTitle = stringResource(id = R.string.signup),
//                                isLoading = viewModel.showProgress
                                isLoading = isLoading
                            )

                            ProvideSpace(height = 0.16f)

                            Row(modifier = Modifier.padding(horizontal = 16.dp)) {

                                Text(
                                    text = stringResource(id = R.string.already_have_an_account),
                                    style = MaterialTheme.typography.labelSmall,
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(text = stringResource(id = R.string.login),
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = MaterialTheme.colorScheme.outline,
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    modifier = Modifier.clickable {
//                                        Log.d("login", "clicked")
                                        navController.navigate("login_screen") // Replace with your actual destination
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
