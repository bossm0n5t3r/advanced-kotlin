package me.bossm0n5t3r.advanced.chapter05

import java.math.BigDecimal

object Exercise01Money {
    data class Money
        @JvmOverloads
        constructor(
            val amount: BigDecimal = BigDecimal.ZERO,
            val currency: Currency = Currency.EUR,
        ) {
            companion object {
                @JvmStatic
                fun eur(amount: String) = Money(BigDecimal(amount), Currency.EUR)

                @JvmStatic
                fun usd(amount: String) = Money(BigDecimal(amount), Currency.USD)

                @JvmField
                val ZERO_EUR = eur("0.00")
            }
        }

    @JvmName("sumMoney")
    fun List<Money>.sum(): Money? {
        if (isEmpty()) return null
        val currency = this.map { it.currency }.toSet().single()
        return Money(
            amount = sumOf { it.amount },
            currency = currency,
        )
    }

    @JvmStatic
    operator fun Money.plus(other: Money): Money {
        require(currency == other.currency)
        return Money(amount + other.amount, currency)
    }

    enum class Currency {
        EUR,
        USD,
    }

    fun main() {
        val money1 = Money.eur("10.00")
        val money2 = Money.eur("29.99")

        println(listOf(money1, money2, money1).sum())
        // Money(amount=49.99, currency=EUR)

        println(money1 + money2)
        // Money(amount=39.99, currency=EUR)

        val money3 = Money.usd("10.00")
        val money4 = Money()
        val money5 = Money(BigDecimal.ONE)
        val money6 = Money.ZERO_EUR
    }
}
