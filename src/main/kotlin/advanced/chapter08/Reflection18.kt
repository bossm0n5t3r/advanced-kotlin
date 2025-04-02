package me.bossm0n5t3r.advanced.chapter08

object Reflection18 {
    sealed class LinkedList<out T>

    class Node<out T>(
        val head: T,
        val next: LinkedList<T>,
    ) : LinkedList<T>()

    data object Empty : LinkedList<Nothing>()

    fun main() {
        println(LinkedList::class.sealedSubclasses)
        // [class Node, class Empty]
    }
}
