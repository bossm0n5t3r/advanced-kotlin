package me.bossm0n5t3r.advanced.chapter03

import kotlin.properties.Delegates.observable

object PropertyDelegation11 {
    private var book: String by observable("") { _, _, _ ->
        page = 0
    }
    private var page = 0

    fun main() {
        book = "TheWitcher"
        repeat(69) { page++ }
        assert(book == "TheWitcher")
        assert(page == 69)
        book = "Ice"
        assert(book == "Ice")
        assert(page == 0)
    }
}
