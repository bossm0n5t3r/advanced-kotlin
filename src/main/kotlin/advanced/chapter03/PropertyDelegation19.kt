package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation19 {
    fun main() {
        var list1 = listOf(1, 2, 3)
        var list2 = list1
        list1 += 4
        assertEquals(listOf(1, 2, 3), list2)
    }
}
