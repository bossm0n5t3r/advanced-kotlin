package me.bossm0n5t3r.advanced.chapter08

object Reflection16 {
    fun main() {
        println(List::class.typeParameters) // [out E]
        println(Map::class.typeParameters) // [K, out V]
    }
}
