package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty2
import kotlin.reflect.full.memberExtensionProperties

object Reflection05 {
    val lock: Any = Any()
    var str: String = "ABC"

    class Box(
        var value: Int = 0,
    ) {
        val Int.addedToBox
            get() = Box(value + this)
    }

    fun main() {
        val p1: KProperty0<Any> = ::lock
        println(p1) // val lock: kotlin.Any
        val p2: KMutableProperty0<String> = ::str
        println(p2) // var str: kotlin.String
        val p3: KMutableProperty1<Box, Int> = Box::value
        println(p3) // var Box.value: kotlin.Int
        val p4: KProperty2<Box, *, *> =
            Box::class
                .memberExtensionProperties
                .first()
        println(p4) // val Box.(kotlin.Int.)addedToBox: Box
    }
}
