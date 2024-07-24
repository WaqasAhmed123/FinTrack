package com.example.fintrack.data.networkService.retrofit

import android.content.Context
import android.util.Log
import com.example.fintrack.corePlatform.globals.internet.NoInternetException
import com.example.fintrack.corePlatform.utilities.ConnectionState
import com.example.fintrack.corePlatform.utilities.currentConnectivityState
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class NetworkInterceptor(private val context: Context) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        // Get the current connectivity state
        val connectivityState = context.currentConnectivityState

        // Check connectivity
        if (connectivityState == ConnectionState.Unavailable) {
        Log.d("ErrorRFNet","${connectivityState == ConnectionState.Unavailable}")
            throw NoInternetException(context)
        }
        Log.d("ErrorRFNet","outside")

        // Proceed with the request if connected
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

}