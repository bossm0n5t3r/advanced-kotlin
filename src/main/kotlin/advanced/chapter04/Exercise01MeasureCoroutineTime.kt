package me.bossm0n5t3r.advanced.chapter04

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.coroutineContext
import kotlin.system.measureTimeMillis
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

object Exercise01MeasureCoroutineTime {
    @OptIn(ExperimentalContracts::class, ExperimentalCoroutinesApi::class)
    suspend fun measureCoroutine(body: suspend () -> Unit): Duration {
        contract {
            callsInPlace(body, InvocationKind.EXACTLY_ONCE)
        }
        val dispatcher = coroutineContext[ContinuationInterceptor]
        return if (dispatcher is TestDispatcher) {
            val before = dispatcher.scheduler.currentTime
            body()
            val after = dispatcher.scheduler.currentTime
            after - before
        } else {
            measureTimeMillis {
                body()
            }
        }.milliseconds
    }
}
