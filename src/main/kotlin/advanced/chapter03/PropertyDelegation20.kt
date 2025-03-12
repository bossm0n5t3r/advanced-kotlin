package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation20 {
    fun main() {
        val list1 = mutableListOf(1, 2, 3)
        val list2 = list1
        list1 += 4
        assertEquals(mutableListOf(1, 2, 3, 4), list2)
    }
}
