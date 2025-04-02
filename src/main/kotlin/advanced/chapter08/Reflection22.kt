package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.typeOf

object Reflection22 {
    class Box<T>

    fun main() {
        val t1 = typeOf<List<Int>>()
        println(t1.arguments) // [kotlin.Int]
        val t2 = typeOf<Map<Long, Char>>()
        println(t2.arguments) // [kotlin.Long, kotlin.Char]
        val t3 = typeOf<Box<out String>>()
        println(t3.arguments) // [out kotlin.String]
    }
}
