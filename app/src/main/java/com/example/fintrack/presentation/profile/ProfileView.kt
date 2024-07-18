package com.example.fintrack.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.presentation.customViews.AddExpenseButton
import com.example.fintrack.presentation.customViews.InputField
import com.example.fintrack.presentation.customViews.InputFieldHeading
import com.example.fintrack.presentation.customViews.ProvideSpace
import com.example.fintrack.presentation.customViews.TitleRow
import com.example.fintrack.corePlatform.globals.common.textfield.TextFieldData
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun ProfileView(navController: NavController, viewModel: ProfileViewModel = hiltViewModel()) {
    var isDarkTheme by remember { mutableStateOf(false) }


    //textfield values
    val username = remember { mutableStateOf(TextFieldValue("")) }
    val phone = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }

    //rendering textfields using lazycol
    val textFieldValues: Map<String, TextFieldData> = mapOf(
        stringResource(id = R.string.user_name) to TextFieldData(
            username, stringResource(id = R.string.example_full_name)
        ), stringResource(id = R.string.mobile_number) to TextFieldData(
            phone, stringResource(id = R.string.example_mobile_number)
        ), stringResource(id = R.string.email) to TextFieldData(
            email, stringResource(id = R.string.example_email)
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

                        TitleRow(
                            title = stringResource(id = R.string.profile),
                            onBackPressClick = {})

                        ProvideSpace(height = 0.06f)

                    }

                }


                // Lower section

                BackgroundContainer() {

                    // Image positioned at the boundary

                    Column(
                        verticalArrangement = Arrangement.Top,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {

                        Box(
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
//                            .zIndex(0.5f) // Ensure image is on top of other components
                                .padding(vertical = 8.dp) // Adjust to position image
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.profile_image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(100.dp) // Adjust size as needed
                                    .clip(MaterialTheme.shapes.medium)
                                    .align(Alignment.Center)
                            )
                        }

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
                                )
                            }
                        }

                        ProvideSpace(height = 0.06f)

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = stringResource(id = R.string.turn_dark_theme),
                                style = MaterialTheme.typography.labelMedium,
                                modifier = Modifier.weight(1f)

                            )


                            Switch(
                                checked = isDarkTheme,
                                onCheckedChange = { isChecked -> isDarkTheme = isChecked },
//                                modifier = Modifier.background(Color.Transparent).border(
//                                        color = MaterialTheme.colorScheme.primary, width = 1.dp
//                                    ).fillMaxSize(), // Makes switch fill the Box
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = MaterialTheme.colorScheme.primary,
                                    uncheckedThumbColor = MaterialTheme.colorScheme.primary,
                                    checkedBorderColor = MaterialTheme.colorScheme.primary,
                                    uncheckedBorderColor = MaterialTheme.colorScheme.primary,
                                    checkedTrackColor = MaterialTheme.colorScheme.primary.copy(
                                        alpha = 0.5f
                                    ),
                                    uncheckedTrackColor = MaterialTheme.colorScheme.tertiary.copy(
                                        alpha = 0.5f
                                    )
                                )
                            )
                        }


                        //below add expenses button
//                        AddExpenseButton(
//                            onClick = { /*TODO*/ },
//                            buttonTitle = stringResource(id = R.string.save),
//                            modifier = Modifier.align(Alignment.CenterHorizontally) // Center the button horizontally
//                        )

                    }
                }
            }
        }
    }

}

