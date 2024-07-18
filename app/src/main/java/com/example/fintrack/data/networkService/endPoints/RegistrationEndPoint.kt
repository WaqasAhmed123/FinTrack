package com.example.fintrack.data.networkService.endPoints

import com.example.fintrack.data.networkService.NetworkAPIUrls
import com.example.fintrack.domain.model.Registration
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.model.dataModel.RegistrationRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RegistrationEndPoint {
    @POST(NetworkAPIUrls.REGISTRATION_API)
    fun register(
        @Body data :RegistrationRequest
    ): Call<Registration>
}