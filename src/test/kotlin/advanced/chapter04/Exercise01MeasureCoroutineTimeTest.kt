package advanced.chapter04

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import me.bossm0n5t3r.advanced.chapter04.Exercise01MeasureCoroutineTime.measureCoroutine
import kotlin.test.Test

class Exercise01MeasureCoroutineTimeTest {
    @Test
    fun main() {
        runTest {
            val result: String
            val duration =
                measureCoroutine {
                    delay(1000)
                    result = "OK"
                }
            println(duration) // 1000 ms
            println(result) // OK
        }

        runBlocking {
            val result: String
            val duration =
                measureCoroutine {
                    delay(1000)
                    result = "OK"
                }
            println(duration) // 1000 ms
            println(result) // OK
        }
    }
}
