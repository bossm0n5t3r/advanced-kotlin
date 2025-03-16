package me.bossm0n5t3r.advanced.chapter04

object Contracts03 {
    fun main() {
        val i: Int
        run {
            i = 42
        }
        assert(i == 42)
    }
}
