package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation18 {
    fun main() {
        val user1 =
            object {
                var name: String = "Rafał"
            }
        val user2 = user1
        user1.name = "Bartek"
        assertEquals("Bartek", user2.name)
    }
}
