package com.alirexa.blubankcompose.domain.entity

import java.util.Date

data class TransactionEntity(
    val amount: Long,
    val date: Date,
    val type: TransactionType,
)