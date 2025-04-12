package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation
import kotlin.reflect.full.memberProperties

object Exercise02JsonSerializer {
    fun serializeToJson(value: Any): String = valueToJson(value)

    private fun valueToJson(value: Any?): String =
        when (value) {
            null, is Number, is Boolean -> "$value"
            is String, is Char, is Enum<*> -> "\"$value\""
            is Iterable<*> -> iterableToJson(value)
            is Map<*, *> -> mapToJson(value)
            else -> objectToJson(value)
        }

    private fun iterableToJson(any: Iterable<*>): String =
        any
            .joinToString(
                prefix = "[",
                postfix = "]",
                transform = ::valueToJson,
            )

    private fun mapToJson(any: Map<*, *>): String =
        any
            .toList()
            .joinToString(
                prefix = "{",
                postfix = "}",
                transform = { (key, value) ->
                    "\"$key\": ${valueToJson(value)}"
                },
            )

    private fun objectToJson(any: Any): String {
        val reference = any::class
        val classNameMapper =
            reference
                .findAnnotation<SerializationNameMapper>()
                ?.let(::createMapper)
        val ignoreNulls =
            reference
                .hasAnnotation<SerializationIgnoreNulls>()

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
                "\"${name}\": ${valueToJson(value)}"
            }.joinToString(prefix = "{", postfix = "}")
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

    @SerializationNameMapper(SnakeCaseName::class)
    @SerializationIgnoreNulls
    class Creature(
        val name: String,
        @SerializationName("att")
        val attack: Int,
        @SerializationName("def")
        val defence: Int,
        val traits: List<Trait>,
        val elementCost: Map<Element, Int>,
        @SerializationNameMapper(LowerCaseName::class)
        val isSpecial: Boolean,
        @SerializationIgnore
        var used: Boolean = false,
        val extraDetails: String? = null,
    )

    object LowerCaseName : NameMapper {
        override fun map(name: String): String = name.lowercase()
    }

    class SnakeCaseName : NameMapper {
        private val pattern = "(?<=.)[A-Z]".toRegex()

        override fun map(name: String): String = name.replace(pattern, "_$0").lowercase()
    }

    enum class Element {
        FOREST,
        ANY,
    }

    enum class Trait {
        FLYING,
    }

    fun main(): String {
        val creature =
            Creature(
                name = "Cockatrice",
                attack = 2,
                defence = 4,
                traits = listOf(Trait.FLYING),
                elementCost =
                    mapOf(
                        Element.ANY to 3,
                        Element.FOREST to 2,
                    ),
                isSpecial = true,
            )
        return serializeToJson(creature)
    }

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
}
