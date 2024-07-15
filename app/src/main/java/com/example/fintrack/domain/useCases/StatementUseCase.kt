package com.example.fintrack.domain.useCases

import com.example.fintrack.corePlatform.globals.callbacks.IResponseCallback
import com.example.fintrack.data.repositories.StatementRepository
import com.example.fintrack.domain.model.Statement
import javax.inject.Inject

class StatementUseCase @Inject constructor(private val statementRepository: StatementRepository) {

    fun callStatementApi(
        userId: String, callback: IResponseCallback<Statement>
    ) {
        return statementRepository.getStatementFromApi(userId , callback = callback)
    }

}