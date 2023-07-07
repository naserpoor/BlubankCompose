package com.alirexa.blubankcompose.data.repository

import com.alirexa.blubankcompose.domain.repository.AccountBalanceRepository
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.delay

@Singleton
class AccountBalanceRepositoryImpl @Inject constructor(): AccountBalanceRepository {
    override suspend fun getAccountBalanceAmount(): Long {
        return 78_500_000
    }
}