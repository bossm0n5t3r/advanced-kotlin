package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation21 {
    fun main() {
        var map = mapOf("a" to 10)
        val a by map
        map = mapOf("a" to 20)
        assertEquals(10, a)
    }
}
