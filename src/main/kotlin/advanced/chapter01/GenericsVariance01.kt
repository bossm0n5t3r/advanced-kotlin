package me.bossm0n5t3r.advanced.chapter01

object GenericsVariance01 {
    interface Animal {
        fun pet()
    }

    class Cat(
        private val name: String,
    ) : Animal {
        override fun pet() {
            println("$name says Meow")
        }
    }

    private fun petAnimals(animals: List<Animal>) {
        for (animal in animals) {
            animal.pet()
        }
    }

    private fun petMutableAnimals(animals: MutableList<Animal>) {
        for (animal in animals) {
            animal.pet()
        }
    }

    fun main() {
        val cats: List<Cat> = listOf(Cat("Mruczek"), Cat("Puszek"))
        petAnimals(cats) // Can I do that? Yes.

        // https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/jvm/builtins/Collections.kt#L124C1-L173
        // public actual interface List<out E> : Collection<E> {
        // ...
        // }

        val mutableCats: MutableList<Cat> = mutableListOf(Cat("Mruczek"), Cat("Puszek"))
        // petMutableAnimals(mutableCats) // Can I do that? No.

        // Type mismatch.
        //      Required:
        //          MutableList<GenericVariance01.Animal>
        //      Found:
        //          MutableList<GenericVariance01.Cat>

        // https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/jvm/builtins/Collections.kt#L179-L238
        // public actual interface MutableList<E> : List<E>, MutableCollection<E> {
        // ...
        // }
    }
}
