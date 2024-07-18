package com.example.fintrack.domain.useCases

import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.data.repositories.RegistrationRepository
import com.example.fintrack.data.repositories.StatementRepository
import com.example.fintrack.domain.model.Registration
import com.example.fintrack.domain.model.Statement
import com.example.fintrack.domain.model.dataModel.RegistrationRequest
import javax.inject.Inject

class RegistrationUseCase @Inject constructor(private val registrationRepository: RegistrationRepository) {

    fun callRegistrationApi(
        data: RegistrationRequest, callback: IResponseCallback<Registration>
    ) {
        return registrationRepository.registerUsingApi(data, callback = callback)
    }
}