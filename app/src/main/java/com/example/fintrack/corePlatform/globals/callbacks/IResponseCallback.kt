package com.example.fintrack.corePlatform.globals.callbacks

interface IResponseCallback <ResultType> : IBaseError{

    fun onSuccess(result: ResultType?)

}