package com.alirexa.blubankcompose.data.repository

import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.domain.entity.TransactionType
import com.alirexa.blubankcompose.domain.repository.TransactionsRepository
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random
import kotlinx.coroutines.delay

@Singleton
class TransactionsRepositoryImpl @Inject constructor() : TransactionsRepository {
    override suspend fun getAllTransactions(): List<TransactionEntity> {
        // To simulate real-world data fetch delay
        delay(1000)
        val random = Random.Default
        return listOf(
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.FEE,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.FEE,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.FEE,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.ATM,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.DEPOSIT_GIFT,
            ),
            TransactionEntity(
                100_000,
                Date(System.currentTimeMillis() - random.nextLong(10_000_000)),
                TransactionType.TRANSFER,
            ),
        )
    }
}