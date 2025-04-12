package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass

object Exercise03XmlSerializer {
    fun serializeToXml(value: Any): String = TODO()

    @Target(AnnotationTarget.PROPERTY)
    annotation class SerializationName(
        val name: String,
    )

    @Target(AnnotationTarget.PROPERTY)
    annotation class SerializationIgnore

    @Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
    annotation class SerializationNameMapper(
        val mapper: KClass<out NameMapper>,
    )

    @Target(AnnotationTarget.CLASS)
    annotation class SerializationIgnoreNulls

    interface NameMapper {
        fun map(name: String): String
    }

    object LowerCaseName : NameMapper {
        override fun map(name: String): String = name.lowercase()
    }

    class SnakeCaseName : NameMapper {
        private val pattern = "(?<=.)[A-Z]".toRegex()

        override fun map(name: String): String = name.replace(pattern, "_$0").lowercase()
    }

    object UpperSnakeCaseName : NameMapper {
        private val pattern = "(?<=.)[A-Z]".toRegex()

        override fun map(name: String): String = name.replace(pattern, "_$0").uppercase()
    }
}
