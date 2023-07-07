package com.alirexa.blubankcompose.domain.repository

import com.alirexa.blubankcompose.domain.entity.TransactionEntity

interface TransactionsRepository {
    suspend fun getAllTransactions(): List<TransactionEntity>
}