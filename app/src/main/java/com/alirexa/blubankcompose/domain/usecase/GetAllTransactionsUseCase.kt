package com.alirexa.blubankcompose.domain.usecase

import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.domain.repository.TransactionsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAllTransactionsUseCase @Inject constructor(private val transactionsRepository: TransactionsRepository) {
    suspend operator fun invoke(): List<TransactionEntity> =
        transactionsRepository.getAllTransactions()
}