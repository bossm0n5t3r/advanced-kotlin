package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals
import kotlin.test.assertTrue

object PropertyDelegation15 {
    class User(
        val map: MutableMap<String, Any>,
    ) {
        var id: Long by map
        var name: String by map
    }

    fun main() {
        val user =
            User(
                mutableMapOf(
                    "id" to 123L,
                    "name" to "Alek",
                ),
            )

        assertEquals("Alek", user.name)
        assertEquals(123, user.id)

        user.name = "Bolek"
        assertEquals("Bolek", user.name)
        assertTrue { mapOf<String, Any>("id" to 123L, "name" to "Bolek") == user.map }

        user.map["id"] = 456
        assertEquals(456, user.id)
        assertTrue { mapOf<String, Any>("id" to 456, "name" to "Bolek") == user.map }
    }
}
