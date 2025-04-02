package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KType
import kotlin.reflect.typeOf
import kotlin.test.assertEquals

object Reflection20 {
    fun main() {
        val t1: KType = typeOf<Int?>()
        assertEquals(
            "kotlin.Int?",
            t1.toString(),
        )
        val t2: KType = typeOf<List<Int?>>()
        assertEquals(
            "kotlin.collections.List<kotlin.Int?>",
            t2.toString(),
        )
        val t3: KType = typeOf<() -> Map<Int, Char?>>()
        assertEquals(
            "() -> kotlin.collections.Map<kotlin.Int, kotlin.Char?>",
            t3.toString(),
        )
    }
}
