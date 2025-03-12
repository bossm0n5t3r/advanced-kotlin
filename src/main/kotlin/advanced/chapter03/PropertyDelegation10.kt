package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.Delegates.observable

object PropertyDelegation10 {
    class ObservableProperty<T>(
        initial: T,
    ) {
        private var observers: List<(T) -> Unit> = listOf()

        var value: T by observable(initial) { _, _, new ->
            observers.forEach { it(new) }
        }

        fun addObserver(observer: (T) -> Unit) {
            observers += observer
        }
    }

    fun main() {
        val name = ObservableProperty("")
        name.addObserver { println("Changed to $it") }
        name.value = "A"
        // Changed to A
        name.addObserver { println("Now it is $it") }
        name.value = "B"
        // Changed to B
        // Now it is B
    }
}
