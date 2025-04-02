package advanced.chapter08

import me.bossm0n5t3r.advanced.chapter08.Exercise01FunctionCaller.FunctionCaller
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

class Exercise01FunctionCallerTest {
    private var value: Any? = null

    fun callStr(str: String) {
        value = "callStr $str"
    }

    fun callInt(int: Int) {
        value = "callInt $int"
    }

    fun callStringInt(
        str: String,
        int: Int,
    ) {
        value = "callStringInt $str $int"
    }

    data class User(
        val id: Int,
        val name: String?,
        var surname: String?,
    )

    fun callUser(user: User) {
        value = user
    }

    fun callWithDefault(
        c: Char,
        i: Int = 999,
        s: String = "XXX",
        l: Long,
    ) {
        value = "callWithDefault $c $i $s $l"
    }

    @AfterEach
    fun cleanUp() {
        value = null
    }

    @Test
    fun testWithString() {
        val caller = FunctionCaller()
        caller.setConstant("ABC")
        caller.call(::callStr)
        assertEquals("callStr ABC", value)
    }

    @Test
    fun testWithInt() {
        val caller = FunctionCaller()
        caller.setConstant(123)
        caller.call(::callInt)
        assertEquals("callInt 123", value)
    }

    @Test
    fun testWithStringInt() {
        val caller = FunctionCaller()
        caller.setConstant("DEF")
        caller.setConstant(456)
        caller.call(::callStringInt)
        assertEquals("callStringInt DEF 456", value)
    }

    @Test
    fun testWithUser() {
        val caller = FunctionCaller()
        val user = User(123, "DEF", "GHI")
        caller.setConstant(user)
        caller.call(::callUser)
        assertEquals(user, value)
    }

    @Test
    fun testIgnoredOptional() {
        val caller = FunctionCaller()
        caller.setConstant('Z')
        caller.setConstant(123L)
        caller.call(::callWithDefault)
        assertEquals("callWithDefault Z 999 XXX 123", value)
    }

    @Test
    fun testValueIsNull() {
        val caller = FunctionCaller()
        assertThrows<IllegalArgumentException> {
            caller.call(::callStr)
        }.also(::println)
    }
}
