package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.typeOf
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object Reflection21 {
    fun main() {
        assertFalse(typeOf<Int>().isMarkedNullable)
        assertTrue(typeOf<Int?>().isMarkedNullable)
    }
}
