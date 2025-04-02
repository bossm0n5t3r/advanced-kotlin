package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KVisibility
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object Reflection11 {
    sealed class UserMessages

    private data class UserId(
        val id: String,
    ) {
        companion object {
            val ZERO = UserId("")
        }
    }

    internal fun interface Filter<T> {
        fun check(value: T): Boolean
    }

    fun main() {
        assertEquals(KVisibility.PUBLIC, UserMessages::class.visibility)
        assertTrue(UserMessages::class.isSealed)
        assertFalse(UserMessages::class.isOpen)
        assertFalse(UserMessages::class.isFinal)
        assertFalse(UserMessages::class.isAbstract)

        assertEquals(KVisibility.PRIVATE, UserId::class.visibility)
        assertTrue(UserId::class.isData)
        assertTrue(UserId::class.isFinal)

        assertTrue(UserId.Companion::class.isCompanion)
        assertFalse(UserId.Companion::class.isInner)

        assertEquals(KVisibility.INTERNAL, Filter::class.visibility)
        assertTrue(Filter::class.isFun)
    }
}
