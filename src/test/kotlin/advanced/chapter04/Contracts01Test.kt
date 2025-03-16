package advanced.chapter04

import me.bossm0n5t3r.advanced.chapter04.Contracts01
import kotlin.test.Test
import kotlin.test.assertEquals

class Contracts01Test {
    @Test
    fun main() {
        assertEquals(6, Contracts01.mul(2, 3))
    }
}
