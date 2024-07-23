package com.example.fintrack.data.repositories

import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.data.networkService.endPoints.StatementEndPoint
import com.example.fintrack.data.networkService.retrofit.RetrofitRestClient
import com.example.fintrack.data.repositories.base.BaseRepository
import com.example.fintrack.domain.model.Statement
import javax.inject.Inject

class StatementRepository @Inject constructor() : BaseRepository<Statement>() {

    private var callback: IResponseCallback<Statement>? = null

    fun getStatementFromApi(userId: String, callback: IResponseCallback<Statement>) {
        this.callback = callback
        getResponseData {
            val apiInterface =
                RetrofitRestClient.getRetrofit().create(StatementEndPoint::class.java)
            apiInterface.getStatement(userId)
        }
    }

    override fun onResponseSuccess(resultType: Statement) {
        callback!!.onSuccess(resultType)
        // Handle the successful response here
        println("NoError: $resultType")
    }

    override fun onResponseFailure(throwable: Throwable) {
        if (throwable is Exception) {
            callback!!.onNetworkError()
        }
        else{
            callback!!.onFailure(message = throwable.toString())
        }
        println("ErrorRF: ${throwable.message}")
    }
}