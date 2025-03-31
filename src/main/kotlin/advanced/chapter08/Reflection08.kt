package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass

object Reflection08 {
    open class A

    class B : A()

    fun main() {
        val a: A = B()
        val clazz: KClass<out A> = a::class
        println(clazz) // class B
    }
}
