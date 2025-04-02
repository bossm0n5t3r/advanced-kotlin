package me.bossm0n5t3r.advanced.chapter08

import kotlin.test.assertEquals

object Reflection19 {
    sealed class LinkedList<out T>

    data class Node<out T>(
        val head: T,
        val next: LinkedList<T>,
    ) : LinkedList<T>()

    data object Empty : LinkedList<Nothing>()

    fun main() {
        assertEquals(null, Node::class.objectInstance)
        assertEquals(Empty, Empty::class.objectInstance)
    }
}
