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
        val dotenv = dotenv {
            directory = "./assets"
            filename = "env"
        }
    }

}