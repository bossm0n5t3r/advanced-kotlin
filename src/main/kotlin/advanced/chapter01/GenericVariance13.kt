package me.bossm0n5t3r.advanced.chapter01

object GenericVariance13 {
    class Box<T>(
        val value: T,
    )

    private val boxStr: Box<String> = Box("Str")
    val boxAny: Box<out Any> = boxStr
}
