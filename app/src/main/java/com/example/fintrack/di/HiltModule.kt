package com.example.fintrack.di

import com.example.fintrack.data.repositories.StatementRepository
import com.example.fintrack.domain.useCases.StatementUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideStatementRepository(): StatementRepository {
        return StatementRepository()
    }

    @Provides
    @Singleton
    fun provideStatementUseCase(statementRepository: StatementRepository): StatementUseCase {
        return StatementUseCase(statementRepository)
    }
}