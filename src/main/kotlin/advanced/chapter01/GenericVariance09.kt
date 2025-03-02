package me.bossm0n5t3r.advanced.chapter01

object GenericVariance09 {
    class Box<out T> {
        private var value: T? = null

        private fun set(value: T) { // OK
            this.value = value
        }

        fun get(): T = value ?: error("Value not set")
    }
}
