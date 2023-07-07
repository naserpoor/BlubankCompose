package com.alirexa.blubankcompose.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alirexa.blubankcompose.di.IODispatcher
import com.alirexa.blubankcompose.domain.entity.AccountBalanceEntity
import com.alirexa.blubankcompose.domain.entity.TransactionEntity
import com.alirexa.blubankcompose.domain.usecase.GetAccountBalanceUseCase
import com.alirexa.blubankcompose.domain.usecase.GetAllTransactionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAccountBalanceUseCase: GetAccountBalanceUseCase,
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Failed)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            loadData()
        }
    }

    private suspend fun loadData() = coroutineScope {
        if (_state.value == State.Loading) {
            return@coroutineScope
        }
        _state.value = State.Loading

        val transactions = async(ioDispatcher) { getAllTransactionsUseCase() }
        val accountBalance = async(ioDispatcher) { getAccountBalanceUseCase() }
        _state.value = State.DataReady(
            accountBalance.await(),
            transactions.await().toImmutableList(),
        )
    }

    sealed interface State {
        object Failed : State
        object Loading : State
        data class DataReady(
            val accountBalance: AccountBalanceEntity,
            val transactionsList: ImmutableList<TransactionEntity>,
        ) : State
    }
}