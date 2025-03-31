package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass

object Reflection07 {
    class A

    fun main() {
        val class1: KClass<A> = A::class
        println(class1) // class A

        val a: A = A()
        val class2: KClass<out A> = a::class
        println(class2) // class A
    }
}
