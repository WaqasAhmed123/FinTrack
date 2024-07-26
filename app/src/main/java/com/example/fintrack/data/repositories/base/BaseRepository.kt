package com.example.fintrack.data.repositories.base

import android.content.Context
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

abstract class BaseRepository<ResultType>(val context: Context) {

    fun getResponseData(apiCall: () -> Call<ResultType>) {
        loadAPIDataFromRemoteServer(apiCall())
    }

    private fun loadAPIDataFromRemoteServer(apiCall: Call<ResultType>) {
        apiCall.enqueue(object : Callback<ResultType> {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun onResponse(call: Call<ResultType>, response: Response<ResultType>) {
                Log.d("Response before", "${response.code()}")
                if (response.isSuccessful) {
                    response.body()?.let {
                        onResponseSuccess(it)
                        Log.d("Response success", "$it")
                    } ?: run {
                        onResponseFailure(Throwable("Response body is null"))
                    }
                } else {
                        Log.d("Response failure", "${response.message()}")
                    onResponseFailure(Throwable("Response not successful: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<ResultType>, t: Throwable) {
                onResponseFailure(t)
            }
        })
    }

    protected abstract fun onResponseSuccess(resultType: ResultType)

    protected abstract fun onResponseFailure(throwable: Throwable)
}
