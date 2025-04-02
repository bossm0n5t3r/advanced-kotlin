package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KFunction
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.jvm.isAccessible
import kotlin.test.assertEquals

object Reflection26 {
    class A {
        private var value = 0

        private fun printValue() {
            println(value)
        }

        override fun toString(): String = "A(value=$value)"
    }

    fun main() {
        val a = A()
        val c = A::class

        // We change value to 999
        val prop = c.declaredMemberProperties.find { it.name == "value" } as? KMutableProperty1<A, Int>
        prop?.isAccessible = true
        prop?.set(a, 999)
        println(a) // A(value=999)
        assertEquals(999, prop?.get(a))

        // We call printValue function
        val func: KFunction<*>? = c.declaredMemberFunctions.find { it.name == "printValue" }
        func?.isAccessible = true
        func?.call(a) // 999
    }
}
