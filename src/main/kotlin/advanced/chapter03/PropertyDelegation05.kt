package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.Delegates

object PropertyDelegation05 {
    private var a: Int by Delegates.notNull()
    private var b: String by Delegates.notNull()

    fun main() {
        a = 10
        println(a) // 10
        a = 20
        println(a) // 20

        println(b) // IllegalStateException:
        // Property b should be initialized before getting.
    }
}
