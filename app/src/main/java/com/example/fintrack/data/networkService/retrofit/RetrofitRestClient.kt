package com.example.fintrack.data.networkService.retrofit

import android.content.Context
import com.example.fintrack.data.networkService.NetworkAPIUrls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitRestClient {
    private var retrofit: Retrofit? = null

    fun getRetrofit(context: Context): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(NetworkAPIUrls.BASE_URL)
                .client(NetworkHttpClient.getOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!

    }

}