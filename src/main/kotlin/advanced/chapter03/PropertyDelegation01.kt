package me.bossm0n5t3r.advanced.chapter03

object PropertyDelegation01 {
    private var token: String? = null
        get() {
            println("token getter returned $field")
            return field
        }
        set(value) {
            println("token changed from $field to $value")
            field = value
        }

    private var attempts: Int = 0
        get() {
            println("attempts getter returned $field")
            return field
        }
        set(value) {
            println("attempts changed from $field to $value")
            field = value
        }

    fun main() {
        token = "AAA" // token changed from null to AAA
        val res = token // token getter returned AAA
        assert(res == "AAA")
        attempts++
        // attempts getter returned 0
        // attempts changed from 0 to 1
    }
}
