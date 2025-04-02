package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KFunction
import kotlin.test.assertEquals

object Reflection13 {
    class User(
        val name: String,
    ) {
        constructor(user: User) : this(user.name)
        constructor(json: UserJson) : this(json.name)
    }

    class UserJson(
        val name: String,
    )

    fun main() {
        val constructors: Collection<KFunction<User>> =
            User::class.constructors

        assertEquals(3, constructors.size)
        constructors.forEach(::println)
        // fun <init>(playground.User): playground.User
        // fun <init>(playground.UserJson): playground.User
        // fun <init>(kotlin.String): playground.User
    }
}
