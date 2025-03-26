package me.bossm0n5t3r.advanced.chapter05

import java.math.BigDecimal

object JavaInteroperability08 {
    class Money(
        val amount: BigDecimal,
        val currency: String,
    ) {
        companion object {
            fun usd(amount: Double) = Money(amount.toBigDecimal(), "PLN")
        }
    }

    object MoneyUtils {
        fun parseMoney(text: String): Money = TODO()
    }

    fun main() {
        val m1 = Money.usd(10.0)
        val m2 = MoneyUtils.parseMoney("10 EUR")
    }

//    public final void main() {
//        Money m1 = JavaInteroperability08.Money.Companion.usd((double)10.0F);
//        Money m2 = JavaInteroperability08.MoneyUtils.INSTANCE.parseMoney("10 EUR");
//    }
}
