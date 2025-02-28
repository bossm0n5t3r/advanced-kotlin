package me.bossm0n5t3r.advanced.chapter01

object GenericVariance06 {
    fun main() {
        val empty: List<Nothing> = emptyList()
        val strs: List<String> = empty
        val ints: List<Int> = empty

        println(empty)
        println(strs)
        println(ints)

        val other: List<Char> = emptyList()
        assert(empty === other) // true

        val oneMore: List<Any> = listOf()
        assert(empty === oneMore) // true
    }
}
