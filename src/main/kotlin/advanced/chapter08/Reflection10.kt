package me.bossm0n5t3r.advanced.chapter08

import kotlin.test.assertEquals

object Reflection10 {
    fun main() {
        val o = object {}
        val clazz = o::class
        assertEquals(null, clazz.simpleName)
        assertEquals(null, clazz.qualifiedName)
    }
}
