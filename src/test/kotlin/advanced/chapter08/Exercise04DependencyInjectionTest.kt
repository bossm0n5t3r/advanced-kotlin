package advanced.chapter08

import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.RealUserRepository
import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.Registry
import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.UserConfiguration
import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.UserRepository
import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.UserService
import me.bossm0n5t3r.advanced.chapter08.Exercise04DependencyInjection.registry
import kotlin.reflect.typeOf
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame
import kotlin.test.assertSame

class Exercise04DependencyInjectionTest {
    private inline fun <reified T : Throwable> assertThrows(operation: () -> Unit) {
        val result = runCatching { operation() }
        assert(result.isFailure) { "Operation has not failed with exception" }
        val exception = result.exceptionOrNull()
        assert(exception is T) { "Incorrect exception type, it should be ${T::class}, but it is $exception" }
    }

    @Test
    fun test() {
        val registry: Registry =
            registry {
                singleton<UserConfiguration> {
                    UserConfiguration("http://localhost:8080")
                }
                normal<UserService> {
                    UserService(
                        userRepository = get(),
                        userConfiguration = get(),
                    )
                }
                singleton<UserRepository> {
                    RealUserRepository(
                        userConfiguration = get(),
                    )
                }
            }

        val userService: UserService = registry.get()
        assertEquals("Got User from http://localhost:8080", userService.get())

        val ur1 = registry.get<UserRepository>()
        val ur2 = registry.get<UserRepository>()
        assertSame(ur1, ur1)

        val uc1 = registry.get<UserService>()
        val uc2 = registry.get<UserService>()
        assertNotSame(uc1, uc2)
    }

    @Test
    fun `should get registered instance`() {
        val registry = Registry()
        registry.register(typeOf<String>()) { "ABC" }
        assertEquals("ABC", registry.get<String>())
    }

    @Test
    fun `should get registered instance with type`() {
        val registry = Registry()
        registry.register<String> { "ABC" }
        assertEquals("ABC", registry.get<String>())
    }

    @Test
    fun `should get registered single instance`() {
        val registry = Registry()
        registry.singleton(typeOf<String>()) { "ABC" }
        assertEquals("ABC", registry.get<String>())
    }

    @Test
    fun `should get registered single instance with type`() {
        val registry = Registry()
        registry.singleton<String> { "ABC" }
        assertEquals("ABC", registry.get<String>())
    }

    @Test
    fun `should return the same singleton instance`() {
        val registry = Registry()

        class A
        registry.singleton(typeOf<A>()) { A() }
        val instance1 = registry.get<A>()
        val instance2 = registry.get<A>()
        assertSame(instance1, instance2)
    }

    @Test
    fun `should return the same singleton instance with type`() {
        val registry = Registry()

        class A
        registry.singleton<A> { A() }
        val instance1 = registry.get<A>()
        val instance2 = registry.get<A>()
        assertSame(instance1, instance2)
    }

    @Test
    fun `should construct instance using registry`() {
        val registry = Registry()

        class B

        class A(
            val b: B,
        )
        registry.register<A> { A(get()) }
        registry.singleton<B> { B() }
        val instance = registry.get<A>()
        assertSame(instance.b, registry.get<B>())
    }

    @Test
    fun `should respond to exists`() {
        val registry = Registry()
        registry.register<String> { "ABC" }
        assertEquals(true, registry.exists<String>())
        assertEquals(false, registry.exists<Int>())
    }

    @Test
    fun `should respond to exists with type`() {
        val registry = Registry()
        registry.register<String> { "ABC" }
        assertEquals(true, registry.exists(typeOf<String>()))
        assertEquals(false, registry.exists(typeOf<Int>()))
    }

    @Test
    fun `should throw exception when not exists`() {
        val registry = Registry()
        registry.register<String> { "ABC" }
        assertThrows<IllegalArgumentException> {
            registry.get<Int>()
        }
    }

    @Test
    fun `should throw exception when not exists with type`() {
        val registry = Registry()
        registry.register<String> { "ABC" }
        assertThrows<IllegalArgumentException> {
            registry.get(typeOf<Int>())
        }
    }

    @Test
    fun `should create instance using DSL`() {
        val registry =
            registry {
                register<String> { "ABC" }
            }
        assertEquals("ABC", registry.get<String>())
    }

    @Test
    fun `should create user service`() {
        val registry: Registry =
            registry {
                singleton<UserConfiguration> {
                    UserConfiguration("http://localhost:8080")
                }
                register<UserService> {
                    UserService(
                        userRepository = get(),
                        userConfiguration = get(),
                    )
                }
                singleton<UserRepository> {
                    RealUserRepository(
                        userConfiguration = get(),
                    )
                }
            }

        val userService: UserService = registry.get()
        assertEquals("Got User from http://localhost:8080", userService.get())

        val ur1 = registry.get<UserRepository>()
        val ur2 = registry.get<UserRepository>()
        assert(ur1 === ur2)

        val uc1 = registry.get<UserService>()
        val uc2 = registry.get<UserService>()
        assert(uc1 !== uc2)
    }
}
