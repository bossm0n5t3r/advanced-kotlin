package me.bossm0n5t3r.advanced.chapter08

import kotlin.test.assertFalse
import kotlin.test.assertTrue

object Reflection15 {
    interface I1

    interface I2

    open class A : I1

    class B :
        A(),
        I2

    fun main() {
        val a = A()
        val b = B()
        assertTrue(A::class.isInstance(a))
        assertFalse(B::class.isInstance(a))
        assertTrue(I1::class.isInstance(a))
        assertFalse(I2::class.isInstance(a))

        assertTrue(A::class.isInstance(b))
        assertTrue(B::class.isInstance(b))
        assertTrue(I1::class.isInstance(b))
        assertTrue(I2::class.isInstance(b))
    }
}
