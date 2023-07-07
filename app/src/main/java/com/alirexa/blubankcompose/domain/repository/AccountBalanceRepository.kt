package com.alirexa.blubankcompose.domain.repository

interface AccountBalanceRepository {
    suspend fun getAccountBalanceAmount(): Long
}