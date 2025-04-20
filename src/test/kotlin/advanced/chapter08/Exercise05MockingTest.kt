package advanced.chapter08

import me.bossm0n5t3r.advanced.chapter08.Exercise05Mocking.MockRegistry
import me.bossm0n5t3r.advanced.chapter08.Exercise05Mocking.User
import me.bossm0n5t3r.advanced.chapter08.Exercise05Mocking.UserRepository
import me.bossm0n5t3r.advanced.chapter08.Exercise05Mocking.UserService
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class Exercise05MockingTest {
    interface GetValue {
        fun getInt(): Int

        fun getIntWithArg(arg: Int): Int

        fun getString(): String
    }

    @Test
    fun mainTest() {
        val registry = MockRegistry()
        val userRepository = registry.mock<UserRepository>()
        val userService = registry.mock<UserService>()

        registry.setReturnValue(
            { userRepository.getUser("alex") },
            User("Alex Smith"),
        )
        registry.setReturnValue(
            { userRepository.getUser("bell") },
            User("Bell Rogers"),
        )
        registry.setReturnValue(
            { userRepository.getUser("dan") },
            null,
        )
        registry.setBody({ userRepository.allUsers() }) {
            listOf(User("James Bond"), User("Jane Doe"))
        }
        registry.setBody({ userService.getUser() }) {
            User(userRepository.getUser("dan")?.name ?: "Unknown")
        }

        assertEquals(User("Alex Smith"), userRepository.getUser("alex"))
        assertEquals(
            listOf(
                User("James Bond"),
                User("Jane Doe"),
            ),
            userRepository.allUsers(),
        )
        assertEquals(
            User(name = "Bell Rogers"),
            userRepository.getUser("bell"),
        )
        assertEquals(
            User("Unknown"),
            userService.getUser(),
        )
        registry.setReturnValue(
            { userRepository.getUser("dan") },
            User("Dan Brown"),
        )
        assertEquals(User("Dan Brown"), userService.getUser())
    }

    @Test
    fun `should throw exception when no value set`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        val result =
            runCatching {
                mock.getInt()
            }
        val exception = result.exceptionOrNull()
        assertNotNull(exception)
        assert(exception is IllegalStateException)
        assertEquals("No handler for method getInt()", exception.message)

        val result2 =
            runCatching {
                mock.getIntWithArg(123)
            }
        val exception2 = result2.exceptionOrNull()
        assertNotNull(exception2)
        assert(exception2 is IllegalStateException)
        assertEquals("No handler for method getIntWithArg(123)", exception2.message)
    }

    @Test
    fun `should set int value`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        registry.setReturnValue({ mock.getInt() }, 123)
        assertEquals(123, mock.getInt())
    }

    @Test
    fun `should set string value`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        registry.setReturnValue({ mock.getString() }, "ABC")
        assertEquals("ABC", mock.getString())
    }

    @Test
    fun `should set int value with arg`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        registry.setReturnValue({ mock.getIntWithArg(123) }, 456)
        registry.setReturnValue({ mock.getIntWithArg(456) }, 789)
        assertEquals(456, mock.getIntWithArg(123))
        assertEquals(789, mock.getIntWithArg(456))
    }

    @Test
    fun `should set constant int body`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        registry.setBody({ mock.getInt() }) { 123 }
        assertEquals(123, mock.getInt())
    }

    @Test
    fun `should set int body`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        var counter = 0
        registry.setBody({ mock.getInt() }) { counter++ }
        assertEquals(0, mock.getInt())
        assertEquals(1, mock.getInt())
        assertEquals(2, mock.getInt())
        assertEquals(3, mock.getInt())
        assertEquals(4, mock.getInt())
        assertEquals(5, mock.getInt())
    }

    @Test
    fun `should set constant string body`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        registry.setBody({ mock.getString() }) { "ABC" }
        assertEquals("ABC", mock.getString())
    }

    @Test
    fun `should set string body`() {
        val registry = MockRegistry()
        val mock = registry.mock<GetValue>()
        var counter = 0
        registry.setBody({ mock.getString() }) { "ABC${counter++}" }
        assertEquals("ABC0", mock.getString())
        assertEquals("ABC1", mock.getString())
        assertEquals("ABC2", mock.getString())
        assertEquals("ABC3", mock.getString())
        assertEquals("ABC4", mock.getString())
        assertEquals("ABC5", mock.getString())
    }

    @Test
    fun `should set body depending on another mock`() {
        val registry = MockRegistry()
        val userRepository = registry.mock<UserRepository>()
        val userService = registry.mock<UserService>()

        registry.setReturnValue(
            { userRepository.getUser("alex") },
            User("Alex Smith"),
        )
        registry.setReturnValue(
            { userRepository.getUser("bell") },
            User("Bell Rogers"),
        )
        registry.setReturnValue(
            { userRepository.getUser("dan") },
            null,
        )
        registry.setBody({ userRepository.allUsers() }) {
            listOf(User("James Bond"), User("Jane Doe"))
        }
        registry.setBody({ userService.getUser() }) {
            User(userRepository.getUser("dan")?.name ?: "Unknown")
        }

        assertEquals(User("Alex Smith"), userRepository.getUser("alex"))
        assertEquals(listOf(User("James Bond"), User("Jane Doe")), userRepository.allUsers())
        assertEquals(User("Bell Rogers"), userRepository.getUser("bell"))
        assertEquals(User("Unknown"), userService.getUser())
        registry.setReturnValue(
            { userRepository.getUser("dan") },
            User("Dan Brown"),
        )
        assertEquals(User("Dan Brown"), userService.getUser())
    }
}
