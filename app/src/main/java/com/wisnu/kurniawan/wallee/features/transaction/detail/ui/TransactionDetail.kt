package com.wisnu.kurniawan.wallee.features.transaction.detail.ui

import com.wisnu.kurniawan.wallee.model.Account
import com.wisnu.kurniawan.wallee.model.CategoryType
import com.wisnu.kurniawan.wallee.model.Currency
import com.wisnu.kurniawan.wallee.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

sealed class TransactionDetail(
    open val amount: BigDecimal,
    open val account: Account,
    open val date: LocalDateTime,
    open val type: TransactionType,
    open val note: String,
    open val currency: Currency,
    open val categoryType: CategoryType
) {
    data class Income(
        override val amount: BigDecimal,
        override val account: Account,
        override val date: LocalDateTime,
        override val type: TransactionType,
        override val note: String,
        override val currency: Currency,
        override val categoryType: CategoryType
    ) : TransactionDetail(
        amount,
        account,
        date,
        type,
        note,
        currency,
        categoryType
    )

    data class Expense(
        override val amount: BigDecimal,
        override val account: Account,
        override val date: LocalDateTime,
        override val type: TransactionType,
        override val note: String,
        override val currency: Currency,
        override val categoryType: CategoryType
    ) : TransactionDetail(
        amount,
        account,
        date,
        type,
        note,
        currency,
        categoryType
    )

    data class Transfer(
        override val amount: BigDecimal,
        override val account: Account,
        override val date: LocalDateTime,
        override val type: TransactionType,
        override val note: String,
        override val currency: Currency,
        override val categoryType: CategoryType,
        val transferAccount: Account,
    ) : TransactionDetail(
        amount,
        account,
        date,
        type,
        note,
        currency,
        categoryType
    )
}
