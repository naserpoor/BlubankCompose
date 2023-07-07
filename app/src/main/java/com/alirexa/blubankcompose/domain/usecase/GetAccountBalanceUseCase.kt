package com.alirexa.blubankcompose.domain.usecase

import com.alirexa.blubankcompose.domain.entity.AccountBalanceEntity
import com.alirexa.blubankcompose.domain.repository.AccountBalanceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAccountBalanceUseCase @Inject constructor(private val accountBalanceRepository: AccountBalanceRepository) {
    suspend operator fun invoke(): AccountBalanceEntity =
        AccountBalanceEntity(accountBalanceRepository.getAccountBalanceAmount())
}