package com.example.fintrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.fintrack.corePlatform.utilities.UiNavigationUtil
import com.example.fintrack.ui.theme.FinTrackTheme
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCenter.start(
            application,
            "c0604a9d-cd62-4377-8453-42beb2812d91",
            Analytics::class.java,
            Crashes::class.java
        )

        setContent {
            FinTrackTheme {
                // A surface container using the 'background' color from the theme
                UiNavigationUtil.App()
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
            }
        }
    }
}
