package me.bossm0n5t3r.advanced.chapter03

object PropertyDelegation09 {
    class Lazy {
        var x = 0
        val y by lazy { 1 / x }

        fun hello() {
            try {
                print(y)
            } catch (e: Exception) {
                x = 1
                print(y)
            }
        }
    }

    fun main() {
        Lazy().hello()
    }
}
