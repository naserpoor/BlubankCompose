package com.alirexa.blubankcompose.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.alirexa.blubankcompose.R
import com.alirexa.blubankcompose.domain.entity.AccountBalanceEntity
import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.presentation.HomeViewModel
import com.alirexa.blubankcompose.presentation.utils.statusBarHeightPx
import com.alirexa.blubankcompose.presentation.utils.toPx
import kotlinx.collections.immutable.ImmutableList


@Composable
fun HomeScreen(state: HomeViewModel.State) {
    when (state) {
        is HomeViewModel.State.DataReady -> {
            HomeScreenContent(state.accountBalance, state.transactionsList)
        }

        HomeViewModel.State.Failed -> {
            // Do Nothing
        }

        HomeViewModel.State.Loading -> {
            // Do nothing
        }
    }
}

@Composable
fun HomeScreenContent(
    accountBalance: AccountBalanceEntity,
    transactions: ImmutableList<TransactionEntity>,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        val headerHeight = dimensionResource(id = R.dimen.home_header_height)
        val grappleHeight = dimensionResource(id = R.dimen.scrollable_card_grapple_height)
        Header(accountBalance, Modifier.height(headerHeight))
        TransactionsCard(
            transactions,
            (headerHeight - grappleHeight).toPx(),
            statusBarHeightPx().toPx(),
        )
    }
}
