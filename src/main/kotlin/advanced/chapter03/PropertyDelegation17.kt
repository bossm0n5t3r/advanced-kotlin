package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation17 {
    fun main() {
        var a = 10
        var b = a
        a = 20
        assertEquals(10, b)
    }
}
