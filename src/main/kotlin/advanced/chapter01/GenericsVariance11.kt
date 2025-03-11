package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance11 {
    class Box<in T>(
        private val value: T,
    ) {
        private fun get(): T =
            value
                ?: error("Value not set")
    }
}
