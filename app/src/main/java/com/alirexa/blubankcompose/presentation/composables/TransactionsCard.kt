package com.alirexa.blubankcompose.presentation.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.alirexa.blubankcompose.R
import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.presentation.mappers.toTransactionItemView
import kotlinx.collections.immutable.ImmutableList

@Composable
fun TransactionsCard(
    transactions: ImmutableList<TransactionEntity>,
    maxOffset: Float,
    minOffset: Float,
) {
    ScrollableCardWithOffset(
        maxOffset = maxOffset,
        minOffset = minOffset,
        cardBackground = colorResource(
            id = R.color.transactions_background,
        ),
    ) {
        items(transactions) {
            TransactionItem(state = it.toTransactionItemView())
        }
        item {
            // Just for better UX
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
        }
    }
}