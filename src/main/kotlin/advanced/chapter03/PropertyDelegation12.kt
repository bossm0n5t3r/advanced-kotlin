package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.Delegates.vetoable
import kotlin.test.assertEquals

object PropertyDelegation12 {
    private var smallList: List<String> by
        vetoable(emptyList()) { _, _, new ->
            println(new)
            new.size <= 3
        }

    fun main() {
        smallList = listOf("A", "B", "C") // [A, B, C]
        assertEquals(listOf("A", "B", "C"), smallList)
        smallList = listOf("D", "E", "F", "G") // [D, E, F, G]
        assertEquals(listOf("A", "B", "C"), smallList)
        smallList = listOf("H") // [H]
        assertEquals(listOf("H"), smallList)
    }
}
