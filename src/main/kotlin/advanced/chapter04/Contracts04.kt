package me.bossm0n5t3r.advanced.chapter04

object Contracts04 {
    fun main() {
        run {
            println("A")
            return
            println("B") // unreachable
        }
        println("C") // unreachable
    }
}
