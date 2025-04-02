package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.full.superclasses
import kotlin.test.assertEquals

object Reflection14 {
    interface I1

    interface I2

    open class A : I1

    class B :
        A(),
        I2

    fun main() {
        val a = A::class
        val b = B::class
        assertEquals(
            listOf(I1::class, Any::class),
            a.superclasses,
        )
        assertEquals(
            listOf(A::class, I2::class),
            b.superclasses,
        )
        println(a.supertypes) // [I1, kotlin.Any]
        println(b.supertypes) // [A, I2]
    }
}
