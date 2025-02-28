package me.bossm0n5t3r.advanced.chapter01

object GenericVariance02 {
    class Consumer<in T> {
        fun <T> consume(value: T): T {
            println("Consuming $value")
            return value
        }
    }

    fun main() {
        val numberConsumer: Consumer<Number> = Consumer()
        assert(numberConsumer.consume(2.71) == 2.71) // Consuming 2.71

        val intConsumer: Consumer<Int> = numberConsumer
        assert(intConsumer.consume(42) == 42) // Consuming 42

        val floatConsumer: Consumer<Float> = numberConsumer
        assert(floatConsumer.consume(3.14F) == 3.14F) // Consuming 3.14

        val anyConsumer: Consumer<Any> = Consumer()
        assert(anyConsumer.consume(123456789L) == 123456789L) // Consuming 123456789

        val stringConsumer: Consumer<String> = anyConsumer
        assert(stringConsumer.consume("ABC") == "ABC") // Consuming ABC

        val charConsumer: Consumer<Char> = anyConsumer
        assert(charConsumer.consume('M') == 'M') // Consuming M
    }
}
