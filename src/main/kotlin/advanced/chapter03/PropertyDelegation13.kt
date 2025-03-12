package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals
import kotlin.test.assertTrue

object PropertyDelegation13 {
    fun main() {
        val map: Map<String, Any> =
            mapOf(
                "name" to "Marcin",
                "kotlinProgrammer" to true,
            )
        val name: String by map
        val kotlinProgrammer: Boolean by map
        assertEquals("Marcin", name)
        assertTrue { kotlinProgrammer }
    }
}
