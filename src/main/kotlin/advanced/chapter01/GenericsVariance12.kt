package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance12 {
    class Box<out T>(
        val value: T,
    )

    private val boxStr: Box<String> = Box("Str")
    val boxAny: Box<Any> = boxStr
}
