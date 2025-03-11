package me.bossm0n5t3r.advanced.chapter02

import kotlinx.coroutines.CoroutineScope

object Exercise01 {
    interface ApplicationControlScope {
        val application: Application

        fun start()

        fun stop()

        fun isRunning(): Boolean
    }

    data class Application(
        val name: String,
    )

    interface LoggingScope {
        fun logInfo(message: String)

        fun logWarning(message: String)

        fun logError(message: String)
    }

    class ApplicationScope(
        private val scope: CoroutineScope,
        private val applicationScope: ApplicationControlScope,
        private val loggingScope: LoggingScope,
    ) : CoroutineScope by scope,
        ApplicationControlScope by applicationScope,
        LoggingScope by loggingScope
}
