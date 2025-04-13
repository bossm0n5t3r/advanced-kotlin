package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties

object Exercise03XmlSerializer {
    fun serializeToXml(value: Any): String = valueToXml(value)

    private fun valueToXml(value: Any?): String =
        when (value) {
            null, is Number, is Boolean, is String, is Char, is Enum<*> -> "$value"
            is Iterable<*> -> iterableToXml(value)
            is Map<*, *> -> mapToXml(value)
            else -> objectToXml(value)
        }

    private fun iterableToXml(any: Iterable<*>): String = any.joinToString(transform = ::valueToXml, separator = "")

    private fun mapToXml(any: Map<*, *>): String =
        any
            .toList()
            .joinToString(
                transform = { (key, value) ->
                    "<$key>${valueToXml(value)}</$key>"
                },
                separator = "",
            )

    private fun objectToXml(any: Any): String {
        val reference = any::class
        val classNameMapper =
            reference
                .findAnnotation<SerializationNameMapper>()
                ?.let(::createMapper)
        val simpleName = reference.simpleName.orEmpty()
        val className = classNameMapper?.map(simpleName) ?: simpleName
        val ignoreNulls = reference.hasAnnotation<SerializationIgnoreNulls>()
        return reference
            .memberProperties
            .filterNot { it.hasAnnotation<SerializationIgnore>() }
            .mapNotNull { property ->
                val annotationName = property.findAnnotation<SerializationName>()
                val mapper =
                    property
                        .findAnnotation<SerializationNameMapper>()
                        ?.let(::createMapper)
                val name =
                    annotationName?.name
                        ?: mapper?.map(property.name)
                        ?: classNameMapper?.map(property.name)
                        ?: property.name
                val value = property.call(any)
                if (ignoreNulls && value == null) {
                    return@mapNotNull null
                }
                "<$name>${valueToXml(value)}</$name>"
            }.joinToString(
                prefix = "<$className>",
                postfix = "</$className>",
                separator = "",
            )
    }

    private fun createMapper(annotation: SerializationNameMapper): NameMapper =
        annotation.mapper.objectInstance
            ?: createWithNoargConstructor(annotation)
            ?: error("Cannot create mapper")

    private fun createWithNoargConstructor(annotation: SerializationNameMapper): NameMapper? =
        annotation.mapper
            .constructors
            .find { it.parameters.isEmpty() }
            ?.call()

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
