package advanced.chapter08

import me.bossm0n5t3r.advanced.chapter08.Reflection04
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class Reflection04Test {
    @Test
    fun main() {
        assertThrows<IllegalArgumentException> {
            Reflection04.main()
        }
    }
}
