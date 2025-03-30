package me.bossm0n5t3r.advanced.chapter08

import kotlin.reflect.KCallable

object Reflection04 {
    fun sendEmail(
        email: String,
        title: String = "",
        message: String = "",
    ) {
        println(
            """
            Sending to $email
            Title: $title
            Message: $message
            """.trimIndent(),
        )
    }

    fun main() {
        val f: KCallable<Unit> = ::sendEmail

        f.callBy(mapOf(f.parameters[0] to "ABC"))
        // Sending to ABC
        // Title:
        // Message:

        val params = f.parameters.associateBy { it.name }
        f.callBy(
            mapOf(
                params["title"]!! to "DEF",
                params["message"]!! to "GFI",
                params["email"]!! to "ABC",
            ),
        )
        // Sending to ABC
        // Title: DEF
        // Message: GFI

        f.callBy(mapOf()) // throws IllegalArgumentException
    }
}
