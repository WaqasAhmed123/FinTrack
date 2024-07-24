package com.example.fintrack.corePlatform.globals.internet

import android.content.Context
import com.example.fintrack.R
import java.io.IOException

class NoInternetException(val context: Context) : IOException() {
    override val message: String
        @Override
        get() = context.resources.getString(R.string.no_internet_connection)

}