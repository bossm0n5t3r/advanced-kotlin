package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance10 {
    open class Car

    interface Boat

    class Amphibious :
        Car(),
        Boat

    class Producer<out T>(
        val factory: () -> T,
    ) {
        fun produce(): T = factory()
    }

    fun main() {
        val producer: Producer<Amphibious> = Producer { Amphibious() }
        val amphibious: Amphibious = producer.produce()
        val boat: Boat = producer.produce()
        val car: Car = producer.produce()

        val boatProducer: Producer<Boat> = producer
        val boat1: Boat = boatProducer.produce()

        val carProducer: Producer<Car> = producer
        val car2: Car = carProducer.produce()
    }
}
