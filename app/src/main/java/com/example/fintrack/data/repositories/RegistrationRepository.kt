package com.example.fintrack.data.repositories

import android.content.Context
import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.corePlatform.globals.internet.NoInternetException
import com.example.fintrack.data.networkService.endPoints.RegistrationEndPoint
import com.example.fintrack.data.networkService.endPoints.StatementEndPoint
import com.example.fintrack.data.networkService.retrofit.RetrofitRestClient
import com.example.fintrack.data.repositories.base.BaseRepository
import com.example.fintrack.domain.model.Registration
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.model.dataModel.RegistrationRequest
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class RegistrationRepository @Inject constructor(@ApplicationContext context: Context) : BaseRepository<Registration>(context) {

    private var callback: IResponseCallback<Registration>? = null

    fun registerUsingApi(data: RegistrationRequest, callback: IResponseCallback<Registration>) {
        this.callback = callback
        getResponseData {
            val apiInterface =
                RetrofitRestClient.getRetrofit(context).create(RegistrationEndPoint::class.java)
            apiInterface.register(data)
        }
    }

    override fun onResponseSuccess(resultType: Registration) {
        callback!!.onSuccess(resultType)
        // Handle the successful response here
        println("Registration: $resultType")
    }

    override fun onResponseFailure(throwable: Throwable) {
        if (throwable is NoInternetException) {

            callback!!.onNetworkError()
            println("ErrorRFExep: ${throwable}")
        } else {
            callback!!.onFailure(message = throwable.toString())
        }
        println("ErrorRF: ${throwable.message}")

    }
}