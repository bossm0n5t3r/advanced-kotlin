package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KCallable

object Reflection03 {
    fun add(
        i: Int,
        j: Int,
    ) = i + j

    fun main() {
        val f: KCallable<Int> = ::add
        println(f.call(1, 2)) // 3
        println(f.call("A", "B")) // IllegalArgumentException
    }
}
