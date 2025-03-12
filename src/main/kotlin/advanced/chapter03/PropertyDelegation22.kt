package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation22 {
    fun main() {
        val mmap = mutableMapOf("a" to 10)
        val a by mmap
        mmap["a"] = 20
        assertEquals(20, a)
    }
}
