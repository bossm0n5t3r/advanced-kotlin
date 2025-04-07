package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KClass

object Exercise02JsonSerializer {
    fun serializeToJson(value: Any): String = TODO()

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
