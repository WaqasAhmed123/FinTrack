package com.example.fintrack.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fintrack.R
import com.example.fintrack.ui.components.BackgroundContainer
import kotlinx.coroutines.flow.collectLatest

@Composable
fun LoginView(navController: NavController) {
    Scaffold {

        Box(

            modifier = Modifier
                .fillMaxSize()
                .padding(it), // Use the padding provided by Scaffold
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom
//                horizontalAlignment = Alignment.CenterHorizontally,


            ) {
                BackgroundContainer(heightPercentage = 0.8f) {
                    Column {

                        Image(
                            painter = painterResource(id = R.drawable.ic_splash_icon), // Replace with your actual icon resource ID
                            contentDescription = "Splash Icon",
                            modifier = Modifier
                                .width(109.dp)
                                .height(114.78.dp)
                        )

                        // Space between icon and text
                        Spacer(modifier = Modifier.height(16.dp))

                        // Text below the icon
                        Text(
                            text = stringResource(id = R.string.app_name), // Use string resource
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                }

            }
        }


    }

}