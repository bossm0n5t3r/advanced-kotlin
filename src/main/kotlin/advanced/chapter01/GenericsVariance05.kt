package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance05 {
    sealed class LinkedList<out T>

    data class Node<T>(
        val head: T,
        val tail: LinkedList<T>,
    ) : LinkedList<T>()

    data object Empty : LinkedList<Nothing>()

    fun main() {
        val strs = Node("A", Node("B", Empty))
        val ints = Node(1, Node(2, Empty))
        val empty: LinkedList<Char> = Empty

        println(strs)
        println(ints)
        println(empty)
    }
}
