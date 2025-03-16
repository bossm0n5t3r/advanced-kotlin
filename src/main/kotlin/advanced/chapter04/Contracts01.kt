package me.bossm0n5t3r.advanced.chapter04

object Contracts01 {
    fun mul(
        x: Int,
        y: Int,
    ): Int {
        require(x > 0)
        require(y > 0)
        return x * y
    }
}
