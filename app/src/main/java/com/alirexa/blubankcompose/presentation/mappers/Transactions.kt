package com.alirexa.blubankcompose.presentation.mappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alirexa.blubankcompose.R
import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.domain.entity.TransactionType
import com.alirexa.blubankcompose.presentation.composables.TransactionItemView
import com.alirexa.blubankcompose.presentation.utils.asCurrency
import com.alirexa.blubankcompose.presentation.utils.dateTimeString

@Composable
fun TransactionEntity.toTransactionItemView(): TransactionItemView {
    val painter = painterResource(
        id = when (type) {
            TransactionType.TRANSFER -> R.drawable.ic_remittance_transfer
            TransactionType.FEE -> R.drawable.ic_fee
            TransactionType.ATM -> R.drawable.ic_atm
            TransactionType.DEPOSIT_GIFT -> R.drawable.ic_deposit_gift
        }
    )
    val isHighlighted = type == TransactionType.DEPOSIT_GIFT
    val title = stringResource(
        id = when (type) {
            TransactionType.TRANSFER -> R.string.remittance_transfer
            TransactionType.FEE -> R.string.fee
            TransactionType.ATM -> R.string.atm
            TransactionType.DEPOSIT_GIFT -> R.string.deposit_gift
        }
    )
    val amount = amount.asCurrency()
    val date = date.dateTimeString()
    return TransactionItemView(
        painter,
        title,
        date,
        amount,
        isHighlighted,
    )
}