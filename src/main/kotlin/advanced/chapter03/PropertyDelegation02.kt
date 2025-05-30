package me.bossm0n5t3r.advanced.chapter03

import kotlin.reflect.KProperty

object PropertyDelegation02 {
    private class LoggingProperty<T>(
        var value: T,
    ) {
        operator fun getValue(
            thisRef: Any?,
            prop: KProperty<*>,
        ): T {
            println("${prop.name} getter returned $value")
            return value
        }

        operator fun setValue(
            thisRef: Any?,
            prop: KProperty<*>,
            newValue: T,
        ) {
            println("${prop.name} changed from $value to $newValue")
            value = newValue
        }
    }

    private var token: String? by LoggingProperty(null)
    private var attempts: Int by LoggingProperty(0)

    fun main() {
        token = "AAA" // token changed from null to AAA
        val res = token // token getter returned AAA
        assert(res == "AAA")
        attempts++
        // attempts getter returned 0
        // attempts changed from 0 to 1
    }
}
