package com.example.fintrack.application

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import io.github.cdimascio.dotenv.Dotenv
import io.github.cdimascio.dotenv.dotenv

@HiltAndroidApp
class GlobalStateApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("onCreateCalled","dfa")
//        val dotenv = Dotenv.configure().directory("/assets").filename("env").load();
        val dotenv = dotenv {
            directory = "./assets"
            filename = "env" // instead of '.env', use 'env'
        }
//        val dotenv = dotenv()
        Log.d("APPCENTER_API_TOKEN","${dotenv["APPCENTER_API_TOKEN"]}" )
    }

}