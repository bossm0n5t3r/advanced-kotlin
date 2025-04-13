package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KType
import kotlin.reflect.typeOf

object Exercise04DependencyInjection {
    class Registry {
        private val creatorsRegistry: MutableMap<KType, () -> Any?> = mutableMapOf()
        private val instances: MutableMap<KType, Any?> = mutableMapOf()

        inline fun <reified T> singleton(noinline creator: Registry.() -> Any?) {
            singleton(typeOf<T>(), creator)
        }

        fun singleton(
            type: KType,
            creator: Registry.() -> Any?,
        ) {
            creatorsRegistry[type] = {
                instances.getOrPut(type) { creator.invoke(this) }
            }
        }

        inline fun <reified T> normal(noinline creator: Registry.() -> Any?) {
            normal(typeOf<T>(), creator)
        }

        fun normal(
            type: KType,
            creator: Registry.() -> Any?,
        ) {
            creatorsRegistry[type] = {
                creator.invoke(this)
            }
        }

        inline fun <reified T> register(noinline creator: Registry.() -> Any?) {
            register(typeOf<T>(), creator)
        }

        fun register(
            type: KType,
            creator: Registry.() -> Any?,
        ) {
            creatorsRegistry[type] = { creator(this) }
        }

        inline fun <reified T> get(): T = get(typeOf<T>()) as T

        fun get(key: KType): Any? {
            require(exists(key)) { "The $key not in registry." }
            return creatorsRegistry[key]?.invoke()
        }

        fun exists(type: KType): Boolean = creatorsRegistry.containsKey(type)

        inline fun <reified T> exists(): Boolean = exists(typeOf<T>())
    }

    fun registry(init: Registry.() -> Unit) = Registry().apply(init)

    data class UserConfiguration(
        val url: String,
    )

    interface UserRepository {
        fun get(): String
    }

    class RealUserRepository(
        private val userConfiguration: UserConfiguration,
    ) : UserRepository {
        override fun get(): String = "User from ${userConfiguration.url}"
    }

    class UserService(
        private val userRepository: UserRepository,
        private val userConfiguration: UserConfiguration,
    ) {
        fun get(): String = "Got ${userRepository.get()}"
    }
}
