package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Exercise01Lateinit {
    class Lateinit<T> : ReadWriteProperty<Any?, T> {
        sealed interface ValueHolder<out T>

        data object Uninitialized : ValueHolder<Nothing>

        data class Value<T>(
            val value: T,
        ) : ValueHolder<T>

        private var valueHolder: ValueHolder<T> = Uninitialized

        override fun getValue(
            thisRef: Any?,
            property: KProperty<*>,
        ): T =
            when (val valueHolder = valueHolder) {
                is Uninitialized -> throw IllegalStateException("Uninitialized lateinit property ${property.name}")
                is Value -> valueHolder.value
            }

        override fun setValue(
            thisRef: Any?,
            property: KProperty<*>,
            value: T,
        ) {
            valueHolder = Value(value)
        }
    }
}
