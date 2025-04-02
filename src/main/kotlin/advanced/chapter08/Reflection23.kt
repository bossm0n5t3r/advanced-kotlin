package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.reflect.KTypeParameter
import kotlin.reflect.typeOf
import kotlin.test.assertFalse
import kotlin.test.assertTrue

object Reflection23 {
    class Box<T>(
        val value: T,
    ) {
        fun get(): T = value
    }

    fun main() {
        val t1 = typeOf<List<Int>>()
        println(t1.classifier) // class kotlin.collections.List
        assertTrue(t1 is KType)
        assertFalse(t1 is KClass<*>)
        val t2 = typeOf<Map<Long, Char>>()
        println(t2.classifier) // class kotlin.collections.Map
        println(t2.arguments[0].type?.classifier) // class kotlin.Long

        val t3 = Box<Int>::get.returnType.classifier
        println(t3) // T
        assertTrue(t3 is KTypeParameter)
    }
}
