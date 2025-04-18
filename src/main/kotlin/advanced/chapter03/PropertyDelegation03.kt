package me.bossm0n5t3r.advanced.chapter03

import kotlin.reflect.KProperty

object PropertyDelegation03 {
    private class LoggingProperty<T>(
        var value: T,
    ) {
        operator fun getValue(
            thisRef: Any?,
            prop: KProperty<*>,
        ): T {
            println("${prop.name} in $thisRef getter returned $value")
            return value
        }

        operator fun setValue(
            thisRef: Any?,
            prop: KProperty<*>,
            newValue: T,
        ) {
            println(
                "${prop.name} in $thisRef changed " +
                    "from $value to $newValue",
            )
            value = newValue
        }
    }

    private var token: String? by LoggingProperty(null)

    object AttemptsCounter {
        var attempts: Int by LoggingProperty(0)
    }

    fun main() {
        token = "AAA" // token in null changed from null to AAA
        val res = token // token in null getter returned AAA
        assert(res == "AAA")

        AttemptsCounter.attempts = 1
        // attempts in AttemptsCounter@XYZ changed from 0 to 1
        val res2 = AttemptsCounter.attempts
        // attempts in AttemptsCounter@XYZ getter returned 1
        assert(res2 == 1)
    }
}
