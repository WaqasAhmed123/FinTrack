package com.example.fintrack.corePlatform.globals.callbacks

interface IBaseError {

    fun onNetworkError()

    fun onFailure(message: String?)
}