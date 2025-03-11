package advanced.chapter02

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import me.bossm0n5t3r.advanced.chapter02.Exercise01.Application
import me.bossm0n5t3r.advanced.chapter02.Exercise01.ApplicationControlScope
import me.bossm0n5t3r.advanced.chapter02.Exercise01.ApplicationScope
import me.bossm0n5t3r.advanced.chapter02.Exercise01.LoggingScope
import kotlin.test.Test

class Exercise01Test {
    class FakeApplicationControlScope(
        override val application: Application,
    ) : ApplicationControlScope {
        private var started = false

        override fun start() {
            started = true
        }

        override fun stop() {
            started = false
        }

        override fun isRunning(): Boolean = started
    }

    class FakeLoggingScope : LoggingScope {
        val messages = mutableListOf<String>()

        override fun logInfo(message: String) {
            messages += "INFO: $message"
        }

        override fun logWarning(message: String) {
            messages += "WARNING: $message"
        }

        override fun logError(message: String) {
            messages += "ERROR: $message"
        }
    }

    private val fakeApplicationScope =
        FakeApplicationControlScope(
            application = Application("Test"),
        )

    private val fakeLoggingScope = FakeLoggingScope()
    private val coroutineScope = CoroutineScope(SupervisorJob())
    private val applicationScope =
        ApplicationScope(
            scope = coroutineScope,
            applicationScope = fakeApplicationScope,
            loggingScope = fakeLoggingScope,
        )

    @Test
    fun `should use coroutine scope`() {
        assert(applicationScope.coroutineContext == coroutineScope.coroutineContext)
    }

    @Test
    fun `should use application scope`() {
        assert(applicationScope.application.name == "Test")
        applicationScope.start()
        assert(fakeApplicationScope.isRunning())
        applicationScope.stop()
        assert(!fakeApplicationScope.isRunning())
    }

    @Test
    fun `should use logging scope`() {
        applicationScope.logInfo("Info")
        applicationScope.logWarning("Warning")
        applicationScope.logError("Error")
        assert(
            fakeLoggingScope.messages ==
                listOf(
                    "INFO: Info",
                    "WARNING: Warning",
                    "ERROR: Error",
                ),
        )
    }
}
