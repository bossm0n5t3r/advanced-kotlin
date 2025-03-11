package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance08 {
    open class Dog

    class Puppy : Dog()

    class Hound : Dog()

    class Box<in T> {
        private var value: T? = null

        fun put(value: T) {
            this.value = value
        }
    }

    fun main() {
        val dogBox = Box<Dog>()
        dogBox.put(Dog())
        dogBox.put(Puppy())
        dogBox.put(Hound())

        val puppyBox: Box<Puppy> = dogBox
        puppyBox.put(Puppy())

        val houndBox: Box<Hound> = dogBox
        houndBox.put(Hound())
    }
}
