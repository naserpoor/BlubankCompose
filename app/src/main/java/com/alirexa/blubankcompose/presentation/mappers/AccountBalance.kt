package com.alirexa.blubankcompose.presentation.mappers

import androidx.compose.runtime.Composable
import com.alirexa.blubankcompose.domain.entity.AccountBalanceEntity
import com.alirexa.blubankcompose.presentation.composables.AccountBalanceView
import com.alirexa.blubankcompose.presentation.utils.asCurrency


@Composable
fun AccountBalanceEntity.toAccountBalanceView() = AccountBalanceView(
    amount.asCurrency()
)