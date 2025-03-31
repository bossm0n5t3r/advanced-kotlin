package me.bossm0n5t3r.advanced.chapter08

object Reflection09 {
    class D {
        class E
    }

    fun main() {
        val clazz = D.E::class
        println(clazz.simpleName) // E
        println(clazz.qualifiedName) // a.b.c.D.E
    }
}
