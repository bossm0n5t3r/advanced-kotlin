package advanced.chapter03

import me.bossm0n5t3r.advanced.chapter03.PropertyDelegation05
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class PropertyDelegation05Test {
    @Test
    fun main() {
        assertThrows<IllegalStateException> {
            PropertyDelegation05.main()
        }
    }
}
