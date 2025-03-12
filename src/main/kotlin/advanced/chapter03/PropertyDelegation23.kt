package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation23 {
    private var map = mapOf("a" to 10)
    private val `a$delegate` = map
    val a: Int
        get() = `a$delegate`.getValue(null, ::a)

    private val mmap = mutableMapOf("b" to 10)
    private val `b$delegate` = mmap
    val b: Int
        get() = `b$delegate`.getValue(null, ::b)

    fun main() {
        map = mapOf("a" to 20)
        assertEquals(10, a)

        mmap["b"] = 20
        assertEquals(20, b)
    }
}
