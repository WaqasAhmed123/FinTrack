package com.example.fintrack.presentation.splash

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fintrack.R

@Composable
fun SplashView(navController: NavController) {

    Scaffold {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), // Use the padding provided by Scaffold
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
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
