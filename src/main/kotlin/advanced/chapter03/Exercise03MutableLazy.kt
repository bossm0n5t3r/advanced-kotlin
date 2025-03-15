package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Exercise03MutableLazy {
    fun <T> mutableLazy(initializer: () -> T): ReadWriteProperty<Any?, T> = MutableLazy(initializer)

    private class MutableLazy<T>(
        private var initializer: (() -> Any?)? = null,
    ) : ReadWriteProperty<Any?, T> {
        private var value: Any? = null

        override fun getValue(
            thisRef: Any?,
            property: KProperty<*>,
        ): T {
            if (initializer != null) {
                value = initializer?.invoke()
                initializer = null
            }
            @Suppress("UNCHECKED_CAST")
            return value as T
        }

        override fun setValue(
            thisRef: Any?,
            property: KProperty<*>,
            value: T,
        ) {
            this.value = value
            initializer = null
        }
    }
}
