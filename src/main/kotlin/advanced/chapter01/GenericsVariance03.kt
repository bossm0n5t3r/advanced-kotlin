package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance03 {
    private fun printProcessedNumber(transformation: (Int) -> Any) {
        println(transformation(42))
    }

    fun main() {
        val intToDouble: (Int) -> Number = { it.toDouble() }
        printProcessedNumber(intToDouble)

        val numberAsText: (Number) -> String = { it.toString() }
        printProcessedNumber(numberAsText)

        val identity: (Number) -> Number = { it }
        printProcessedNumber(identity)

        val numberToInt: (Number) -> Int = { it.toInt() }
        printProcessedNumber(numberToInt)

        val numberHash: (Any) -> Number = { it.hashCode() }
        printProcessedNumber(numberHash)
    }
}
