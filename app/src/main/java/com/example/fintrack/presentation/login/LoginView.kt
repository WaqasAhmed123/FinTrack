package com.example.fintrack.presentation.login

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.corePlatform.customViews.InputField
import com.example.fintrack.corePlatform.customViews.InputFieldHeading
import com.example.fintrack.corePlatform.customViews.ProvideSpace
import com.example.fintrack.corePlatform.customViews.SubmitButton
import com.example.fintrack.ui.components.BackgroundContainer

@Composable
fun LoginView(navController: NavController) {
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
                            text = stringResource(id = R.string.welcome),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                }

                // Lower section

                BackgroundContainer(heightPercentage = 1f) {

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        val email = remember { mutableStateOf(TextFieldValue("")) }
                        val password = remember { mutableStateOf(TextFieldValue("")) }

                        InputFieldHeading(text = stringResource(id = R.string.email))

                        InputField(
                            value = email.value,
                            onValueChange = { email.value = it },
                            placeholder = stringResource(id = R.string.example_email)
                        )
                        InputFieldHeading(
                            text = stringResource(id = R.string.password)
                        )
                        InputField(
                            value = password.value,
                            onValueChange = { password.value = it },
                            placeholder = "",
                            isPassword = true
                        )

                        ProvideSpace(height = 0.13f)

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        ) {

                            SubmitButton(
                                onClick = { navController.navigate("tab_screen") },
                                buttonTitle = stringResource(id = R.string.login)
                            )

                            TextButton(onClick = {}) {
                                Text(
                                    text = stringResource(id = R.string.forgot_password),
                                    style = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.scrim)
                                )
                            }

                            SubmitButton(
                                onClick = { },
                                buttonTitle = stringResource(id = R.string.signup),
                                color = MaterialTheme.colorScheme.tertiary
                            )

                            ProvideSpace(height = 0.1f)

                            Text(
                                text = stringResource(id = R.string.or_sign_up_with),
                                style = MaterialTheme.typography.labelSmall.copy(color = MaterialTheme.colorScheme.scrim)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
//                            verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_facebook),
                                    contentDescription = "Facebook",
                                    modifier = Modifier
                                        .size(60.dp)
                                        .padding(10.dp)
                                )

                                Image(
                                    painter = painterResource(id = R.drawable.ic_google),
                                    contentDescription = "Google",
                                    modifier = Modifier
                                        .size(60.dp)
                                        .padding(10.dp)
                                )
                            }

                            ProvideSpace(height = 0.16f)

                            Row(modifier = Modifier.padding(horizontal = 16.dp)) {
                                Text(
                                    text = stringResource(id = R.string.dont_have_an_account),
                                    style = MaterialTheme.typography.labelSmall,
                                )

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(text = stringResource(id = R.string.signup),
                                    style = MaterialTheme.typography.labelSmall.copy(
                                        color = MaterialTheme.colorScheme.outline,
                                        textDecoration = TextDecoration.Underline
                                    ),
                                    modifier = Modifier.clickable {
                                        navController.navigate("signup_screen")
                                    })
                            }
                        }
                    }
                }
            }
        }
    }
}
