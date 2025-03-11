package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance07 {
    sealed class Either<out L, out R>

    data class Left<out L>(
        val value: L,
    ) : Either<L, Nothing>()

    data class Right<out R>(
        val value: R,
    ) : Either<Nothing, R>()
}
