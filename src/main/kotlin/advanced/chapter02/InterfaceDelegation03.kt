package me.bossm0n5t3r.advanced.chapter02

object InterfaceDelegation03 {
    interface Creature {
        val attackPower: Int
        val defensePower: Int

        fun attack()
    }

    class GenericCreature(
        override val attackPower: Int,
        override val defensePower: Int,
    ) : Creature {
        override fun attack() {
            println("Attacking with $attackPower")
        }
    }

    class Goblin : Creature by GenericCreature(2, 1) {
        // ...
    }

    fun main() {
        val goblin = Goblin()
        assert(1 == goblin.defensePower)
        goblin.attack() // Attacking with 2
    }
}
