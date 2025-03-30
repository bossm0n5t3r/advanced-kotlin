package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KMutableProperty1

object Reflection06 {
    class Box(
        var value: Int = 0,
    )

    fun main() {
        val box = Box()
        val p: KMutableProperty1<Box, Int> = Box::value
        println(p.get(box)) // 0
        p.set(box, 999)
        println(p.get(box)) // 999
    }
}
