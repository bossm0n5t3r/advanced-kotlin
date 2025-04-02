package me.bossm0n5t3r.advanced.chapter08

import java.lang.reflect.Field
import java.lang.reflect.Method
import kotlin.reflect.KClass
import kotlin.reflect.KFunction
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter
import kotlin.reflect.jvm.javaMethod
import kotlin.reflect.jvm.kotlinFunction
import kotlin.reflect.jvm.kotlinProperty

object Reflection25 {
    class A {
        val a = 123

        fun b() {}
    }

    fun main() {
        val c1: Class<A> = A::class.java
        val c2: Class<A> = A().javaClass

        val f1: Field? = A::a.javaField
        val f2: Method? = A::a.javaGetter
        val f3: Method? = A::b.javaMethod

        val kotlinClass: KClass<A> = c1.kotlin
        val kotlinProperty: KProperty<*>? = f1?.kotlinProperty
        val kotlinFunction: KFunction<*>? = f3?.kotlinFunction
    }
}
