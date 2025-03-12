package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation14 {
    class User(
        val map: Map<String, Any>,
    ) {
        val id: Long by map
        val name: String by map
    }

    fun main() {
        val user =
            User(
                mapOf<String, Any>(
                    "id" to 1234L,
                    "name" to "Marcin",
                ),
            )
        assertEquals("Marcin", user.name)
        assertEquals(1234L, user.id)
        assertEquals(mapOf("id" to 1234L, "name" to "Marcin"), user.map)
    }
}
