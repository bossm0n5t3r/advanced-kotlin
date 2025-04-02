package me.bossm0n5t3r.advanced.chapter08

object Reflection17 {
    class A {
        class B

        inner class C
    }

    fun main() {
        println(A::class.nestedClasses) // [class A$B, class A$C]
    }
}
