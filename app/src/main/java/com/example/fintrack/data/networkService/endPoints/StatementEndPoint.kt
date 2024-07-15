package com.example.fintrack.data.networkService.endPoints

import com.example.fintrack.data.networkService.NetworkAPIUrls
import com.example.fintrack.domain.model.Statement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface StatementEndPoint {
    @GET(NetworkAPIUrls.STATEMENT_API)
    fun getStatement(
        @Query("userId") userId: String
    ): Call<Statement>
}