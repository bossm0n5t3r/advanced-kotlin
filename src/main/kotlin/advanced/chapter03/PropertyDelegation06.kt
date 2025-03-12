package me.bossm0n5t3r.advanced.chapter03

object PropertyDelegation06 {
    class OurLanguageParser {
        val cardRegex by lazy { Regex("...") }
        val questionRegex by lazy { Regex("...") }
        val answerRegex by lazy { Regex("...") }

        // ...
    }
}
