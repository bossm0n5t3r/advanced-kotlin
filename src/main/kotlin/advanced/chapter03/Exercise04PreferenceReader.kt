package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object Exercise04PreferenceReader {
    object Preferences : PreferenceReaderBinder("UserPreferences") {
        var token by preferenceField("token")
        var id by preferenceField("id")
    }

    open class PreferenceReaderBinder(
        val name: String,
    ) {
        private val reader = PreferenceReader(name)

        fun preferenceField(preference: String): ReadWriteProperty<Any?, String> =
            object : ReadWriteProperty<Any?, String> {
                override fun getValue(
                    thisRef: Any?,
                    property: KProperty<*>,
                ): String = reader.read(preference) ?: ""

                override fun setValue(
                    thisRef: Any?,
                    property: KProperty<*>,
                    value: String,
                ) {
                    reader.write(preference, value)
                }
            }
    }

    class PreferenceReader(
        private val name: String,
    ) {
        fun read(preference: String): String? = FakePreferences.preferences[name to preference]

        fun write(
            preference: String,
            value: String?,
        ) {
            FakePreferences.preferences += (name to preference) to value
        }
    }

    object FakePreferences {
        // Maps preference file name and preference field name to actual value
        var preferences: Map<Pair<String, String>, String?> = mapOf()
    }
}
