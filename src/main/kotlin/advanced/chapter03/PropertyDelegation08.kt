package me.bossm0n5t3r.advanced.chapter03

object PropertyDelegation08 {
    private val IS_VALID_IP_REGEX by lazy {
        (
            "\\A(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\z"
        ).toRegex()
    }

    fun String.isValidIpAddress(): Boolean = matches(IS_VALID_IP_REGEX)
}
