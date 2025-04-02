package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties
import kotlin.test.assertEquals

object Reflection12 {
    open class Parent {
        val a = 12

        fun b() {}
    }

    class Child : Parent() {
        val c = 12

        fun d() {}
    }

    fun Child.e() {}

    fun main() {
        assertEquals(
            listOf("c", "d", "a", "b", "equals", "hashCode", "toString"),
            Child::class.members.map { it.name },
        )

        assertEquals(
            listOf("d", "b", "equals", "hashCode", "toString"),
            Child::class.functions.map { it.name },
        )

        assertEquals(
            listOf("c", "a"),
            Child::class.memberProperties.map { it.name },
        )

        assertEquals(
            listOf("c", "d"),
            Child::class.declaredMembers.map { it.name },
        )

        assertEquals(
            listOf("d"),
            Child::class.declaredFunctions.map { it.name },
        )

        assertEquals(
            listOf("c"),
            Child::class.declaredMemberProperties.map { it.name },
        )
    }
}
