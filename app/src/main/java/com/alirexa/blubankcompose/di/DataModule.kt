package com.alirexa.blubankcompose.di

import com.alirexa.blubankcompose.data.repository.AccountBalanceRepositoryImpl
import com.alirexa.blubankcompose.data.repository.TransactionsRepositoryImpl
import com.alirexa.blubankcompose.domain.repository.AccountBalanceRepository
import com.alirexa.blubankcompose.domain.repository.TransactionsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideAccountBalanceRepository(accountBalanceRepositoryImpl: AccountBalanceRepositoryImpl): AccountBalanceRepository =
        accountBalanceRepositoryImpl

    @Provides
    fun provideTransactionsRepository(transactionsRepositoryImpl: TransactionsRepositoryImpl): TransactionsRepository =
        transactionsRepositoryImpl
}