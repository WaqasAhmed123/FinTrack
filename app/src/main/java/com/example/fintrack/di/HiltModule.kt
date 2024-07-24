package com.example.fintrack.di

import android.content.Context
import com.example.fintrack.data.repositories.RegistrationRepository
import com.example.fintrack.data.repositories.StatementRepository
import com.example.fintrack.domain.useCases.RegistrationUseCase
import com.example.fintrack.domain.useCases.StatementUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideStatementRepository(@ApplicationContext context: Context): StatementRepository {
        return StatementRepository(context)
    }

    @Provides
    @Singleton
    fun provideStatementUseCase(statementRepository: StatementRepository): StatementUseCase {
        return StatementUseCase(statementRepository)
    }
    @Provides
    @Singleton
    fun provideRegistrationRepository(@ApplicationContext context: Context): RegistrationRepository {
        return RegistrationRepository(context)
    }

    @Provides
    @Singleton
    fun provideRegistrationUseCase(registrationRepository: RegistrationRepository): RegistrationUseCase {
        return RegistrationUseCase(registrationRepository)
    }

}