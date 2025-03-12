package me.bossm0n5t3r.advanced.chapter03

import kotlin.test.assertEquals

object PropertyDelegation24 {
    class Population(
        var cities: Map<String, Int>,
    ) {
        val sanFrancisco by cities
        val tallinn by cities
        val kotlin by cities
    }

    private val population =
        Population(
            mapOf(
                "sanFrancisco" to 864_816,
                "tallinn" to 413_782,
                "kotlin" to 43_005,
            ),
        )

    fun main() {
        // Years has passed,
        // now we all live on Mars
        population.cities = emptyMap()
        assertEquals(864_816, population.sanFrancisco)
        assertEquals(413_782, population.tallinn)
        assertEquals(43_005, population.kotlin)
    }
}
