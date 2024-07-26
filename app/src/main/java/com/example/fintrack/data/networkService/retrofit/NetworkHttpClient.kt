package com.example.fintrack.data.networkService.retrofit

import android.content.Context
import okhttp3.OkHttpClient

object NetworkHttpClient {
    fun getOkHttpClient(context: Context): OkHttpClient {
        val okHttpClient =
            OkHttpClient.Builder().addInterceptor(NetworkInterceptor(context)).build()

        return okHttpClient
    }
}